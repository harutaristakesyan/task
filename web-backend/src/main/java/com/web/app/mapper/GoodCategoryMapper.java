package com.web.app.mapper;

import com.web.app.persistence.domain.GoodCategoryDomain;
import com.web.app.service.GoodCategoryService;
import com.web.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodCategoryKafkaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TextMapper.class})
public interface GoodCategoryMapper extends KafkaModelMapper<GoodCategoryKafkaModel, GoodCategoryDomain> {

    @Mapping(target = "name", source = "names", qualifiedByName = "collectText")
    GoodCategoryService.GoodCategoryResponse toResponse(final GoodCategoryDomain entity);
}
