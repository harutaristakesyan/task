package com.admin.app.mapper;

import com.admin.app.persistence.domain.GoodCollectionDomain;
import com.admin.app.service.GoodCollectionService;
import com.admin.core.mapper.EntityMapper;
import com.admin.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodCollectionKafkaModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {TextMapper.class, GoodBrandMapper.class, FileMapper.class})
public interface GoodsCollectionMapper extends EntityMapper<GoodCollectionService.GoodCollectionRequest, GoodCollectionDomain>,
        KafkaModelMapper<GoodCollectionKafkaModel, GoodCollectionDomain> {

    GoodCollectionService.GoodCollectionSearchResponse toSearchResponse(final GoodCollectionDomain entity);

    @Named("toResponseWhitFile")
    GoodCollectionService.GoodCollectionResponse toResponseWhitFile(final GoodCollectionDomain entity, @Context final String imageUrl);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "brand.id", source = "brand")
    GoodCollectionDomain toEntity(GoodCollectionService.GoodCollectionRequest request);


    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "brand.id", source = "brand")
    void updateDomain(@MappingTarget GoodCollectionDomain target, GoodCollectionService.GoodCollectionRequest source);
}
