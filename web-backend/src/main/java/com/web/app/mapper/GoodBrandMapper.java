package com.web.app.mapper;


import com.web.app.persistence.domain.GoodBrandDomain;
import com.web.app.service.GoodBrandService;
import com.web.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodBrandKafkaModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TextMapper.class, FileMapper.class})
public interface GoodBrandMapper extends KafkaModelMapper<GoodBrandKafkaModel, GoodBrandDomain> {

    @Mapping(target = "description", source = "descriptions", qualifiedByName = "collectText")
    GoodBrandService.GoodBrandResponse toResponse(final GoodBrandDomain entity, @Context final String imageUrl);

}
