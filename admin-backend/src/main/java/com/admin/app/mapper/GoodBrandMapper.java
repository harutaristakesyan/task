package com.admin.app.mapper;

import com.admin.app.persistence.domain.GoodBrandDomain;
import com.admin.app.service.GoodBrandService;
import com.admin.core.mapper.EntityMapper;
import com.admin.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodBrandKafkaModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {TextMapper.class, FileMapper.class})
public interface GoodBrandMapper extends EntityMapper<GoodBrandService.GoodBrandRequest, GoodBrandDomain>,
        KafkaModelMapper<GoodBrandKafkaModel, GoodBrandDomain> {

    @Named("toResponseWhitFile")
    GoodBrandService.GoodBrandResponse toResponseWhitFile(final GoodBrandDomain entity, @Context final String imageUrl);

    @Mapping(target = "logo", ignore = true)
    GoodBrandService.GoodBrandResponse toResponse(final GoodBrandDomain entity);

    @Mapping(target = "logo", ignore = true)
    @Mapping(target = "description", source = "descriptions", qualifiedByName = "collectText")
    GoodBrandService.GoodBrandSearchResponse toSearchResponse(final GoodBrandDomain entity);

    @Named("toSearchResponseWhitFile")
    @Mapping(target = "description", source = "descriptions", qualifiedByName = "collectText")
    GoodBrandService.GoodBrandSearchResponse toSearchResponseWhitFile(final GoodBrandDomain entity, @Context final String imageUrl);

}
