package com.web.app.mapper;

import com.web.app.persistence.domain.GoodDomain;
import com.web.app.service.GoodsService;
import com.web.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodsKafkaModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TextMapper.class, FileMapper.class, GoodCategoryMapper.class, GoodBrandMapper.class})
public interface GoodsMapper extends KafkaModelMapper<GoodsKafkaModel, GoodDomain> {

    @Mapping(target = "title", source = "titles", qualifiedByName = "collectText")
    @Mapping(target = "description", source = "descriptions", qualifiedByName = "collectText")
    GoodsService.GoodResponse toResponse(final GoodDomain entity, @Context final String imageUrl);

}
