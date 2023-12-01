package com.admin.app.mapper;

import com.admin.app.persistence.domain.GoodDomain;
import com.admin.app.service.GoodsService;
import com.admin.core.mapper.EntityMapper;
import com.admin.core.mapper.KafkaFileModelMapper;
import com.admin.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodsKafkaModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {TextMapper.class, FileMapper.class,
        GoodCategoryMapper.class, KafkaFileModelMapper.class, PromotionMapper.class, GoodsCollectionMapper.class
})
public interface GoodsMapper extends EntityMapper<GoodsService.GoodRequest, GoodDomain>,
        KafkaModelMapper<GoodsKafkaModel, GoodDomain> {

    GoodsService.GoodResponse toResponseWhitFile(final GoodDomain entity, @Context final String imageUrl);

    @Mapping(target = "title", source = "titles", qualifiedByName = "collectText")
    @Mapping(target = "description", source = "descriptions", qualifiedByName = "collectText")
    GoodsService.GoodSearchResponse toSearchResponseWhitFile(final GoodDomain entity, @Context final String imageUrl);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "collection.id", source = "collection")
    @Mapping(target = "category.id", source = "category")
    @Mapping(target = "promotion.id", source = "promotion")
    GoodDomain toEntity(GoodsService.GoodRequest request);


    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "category.id", source = "category")
    @Mapping(target = "promotion.id", source = "promotion")
    @Mapping(target = "collection.id", source = "collection")
    void updateDomain(@MappingTarget GoodDomain target, GoodsService.GoodRequest source);
}
