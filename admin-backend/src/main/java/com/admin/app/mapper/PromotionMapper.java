package com.admin.app.mapper;

import com.admin.app.persistence.domain.PromotionDomain;
import com.admin.app.service.PromotionsService;
import com.admin.core.mapper.EntityMapper;
import com.admin.core.mapper.KafkaModelMapper;
import kafka.models.promotion.PromotionKafkaModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {TextMapper.class, FileMapper.class})
public interface PromotionMapper extends EntityMapper<PromotionsService.PromotionsRequest, PromotionDomain>,
        KafkaModelMapper<PromotionKafkaModel, PromotionDomain> {

    @Named("toResponseWhitFile")
    PromotionsService.PromotionResponse toResponseWhitFile(final PromotionDomain entity, @Context final String imageUrl);

    @Mapping(target = "image", ignore = true)
    PromotionsService.PromotionResponse toResponse(final PromotionDomain entity);

    @Mapping(target = "image", ignore = true)
    @Mapping(target = "text", source = "texts", qualifiedByName = "collectText")
    PromotionsService.PromotionSearchResponse toSearchResponse(final PromotionDomain entity);

}
