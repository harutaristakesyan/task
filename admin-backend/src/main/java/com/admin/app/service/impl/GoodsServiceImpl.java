package com.admin.app.service.impl;

import com.admin.app.kafka.producer.GoodsKafkaProducer;
import com.admin.app.mapper.GoodsMapper;
import com.admin.app.persistence.domain.GoodCategoryDomain;
import com.admin.app.persistence.domain.GoodDomain;
import com.admin.app.persistence.domain.TextDomain;
import com.admin.app.persistence.repository.GoodBrandRepository;
import com.admin.app.persistence.repository.GoodCategoryRepository;
import com.admin.app.persistence.repository.GoodCollectionRepository;
import com.admin.app.persistence.repository.GoodsRepository;
import com.admin.app.service.GoodsService;
import com.admin.app.service.model.GoodsSearchCriteria;
import com.admin.core.config.ExternalApiProperties;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.Void;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;

@Service
@Transactional
@RequiredArgsConstructor
class GoodsServiceImpl implements GoodsService {

    private final GoodsMapper goodsMapper;

    private final GoodsRepository goodsRepository;

    private final GoodsKafkaProducer goodsKafkaProducer;

    private final ExternalApiProperties externalApiProperties;

    private final GoodCategoryRepository goodCategoryRepository;

    private final GoodCollectionRepository goodCollectionRepository;

    private static final Map<Integer, BiConsumer<GoodDomain, Object>> goods_setter = new HashMap<>();

    static {
        goods_setter.put(2, (goods, value) -> goods.setFinish(value.toString()));
        goods_setter.put(3, (goods, value) -> goods.setUsage(value.toString()));
        goods_setter.put(4, (goods, value) -> goods.setArea(value.toString()));
        goods_setter.put(5, (goods, value) -> goods.setMaterial(value.toString()));
        goods_setter.put(6, (goods, value) -> goods.setColor(value.toString()));
        goods_setter.put(7, (goods, value) -> goods.setSalePrice(BigDecimal.valueOf(Double.parseDouble(value.toString()))));
        goods_setter.put(8, (goods, value) -> goods.setWarranty(BigDecimal.valueOf(Double.parseDouble(value.toString()))));
        goods_setter.put(9, (goods, value) -> goods.setVolume(value.toString()));
        goods_setter.put(10, (goods, value) -> addTitle(value.toString(), goods));
        goods_setter.put(11, (goods, value) -> goods.setVendorCode(value.toString()));
    }

    private static void addTitle(final String value, final GoodDomain goods) {
        var titleRu = new TextDomain();
        titleRu.setLangCode("ru");
        titleRu.setText(value);
        var titleEn = new TextDomain();
        titleEn.setLangCode("en");
        titleEn.setText(value);
        goods.setTitles(Set.of(titleRu, titleEn));
    }

    @Override
    public Void add(final GoodRequest request) {
        final var goodDomain = goodsMapper.toEntity(request);
        return Void.exec(goodsKafkaProducer::add, goodsMapper.toKafkaModel(goodsRepository.save(goodDomain)));
    }

    @Override
    public GoodResponse get(final UUID id) {
        return goodsMapper.toResponseWhitFile(findDomain(id), externalApiProperties.getFileManagement());
    }

    @Override
    public AbstractListResponse<GoodSearchResponse> search(final GoodsSearchCriteria searchCriteria) {
        final var goods = goodsRepository.findAll(searchCriteria.toPage());
        return ResponseUtil.build(goods.getTotalElements(), goods.stream().map(this::buildResponse).toList());
    }

    @Override
    public Void update(final UUID uuid, final GoodRequest request) {
        final var domain = findDomain(uuid);
        goodsMapper.updateDomain(domain, request);
        return Void.exec(goodsKafkaProducer::add, goodsMapper.toKafkaModel(goodsRepository.save(domain)));
    }

    @Override
    public Void delete(final UUID uuid) {
        final var domain = findDomain(uuid);
        goodsRepository.delete(domain);
        return Void.exec(goodsKafkaProducer::delete, goodsMapper.toKafkaModel(domain));
    }

    private GoodSearchResponse buildResponse(final GoodDomain domain) {
        return goodsMapper.toSearchResponseWhitFile(domain, externalApiProperties.getFileManagement());
    }

    private GoodDomain findDomain(final UUID uuid) {
        return goodsRepository.findById(uuid).orElseThrow(entityNotFoundException(GoodDomain.class, uuid));
    }

    @Override
    public Void importGoods(final MultipartFile file) {

        try {
            CSVParser csvParser = new CSVParser(new InputStreamReader(file.getInputStream()), CSVFormat.DEFAULT.builder().setTrim(true).setHeader().setSkipHeaderRecord(true).setIgnoreHeaderCase(true).build());
            Iterator<CSVRecord> good = csvParser.iterator();
            final Set<GoodDomain> goods = new HashSet<>();
            while (good.hasNext()) {
                CSVRecord csvRecord = good.next();
                final var goodDomain = new GoodDomain();
                final var category = goodCategoryRepository.findByNames(csvRecord.get(0))
                        .orElseThrow(entityNotFoundException(GoodCategoryDomain.class, csvRecord.get(0)));
                goodDomain.setCategory(category);

                final var collection = goodCollectionRepository.findByName(csvRecord.get(1))
                        .orElseThrow(entityNotFoundException(GoodCategoryDomain.class, csvRecord.get(1)));
                goodDomain.setCollection(collection);
                for (int i = 2; i < csvRecord.size(); i++) {
                    goods_setter.get(i).accept(goodDomain, csvRecord.get(i));
                }

                goodDomain.setAvailability(Boolean.TRUE);
                goods.add(goodDomain);
            }

            goodsRepository.saveAll(goods);

            for (final GoodDomain goodDomain : goods) {
                goodsKafkaProducer.add(goodsMapper.toKafkaModel(goodDomain));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Void.VOID.get();
    }
}
