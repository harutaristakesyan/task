package com.admin.app.mapper;

import com.admin.app.persistence.domain.GoodCategoryDomain;
import com.admin.app.service.GoodCategoryService;
import com.admin.core.mapper.DtoMapper;
import com.admin.core.mapper.EntityMapper;
import com.admin.core.mapper.KafkaModelMapper;
import kafka.models.goods.GoodCategoryKafkaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TextMapper.class})
public interface GoodCategoryMapper extends EntityMapper<GoodCategoryService.GoodCategoryRequest, GoodCategoryDomain>,
        DtoMapper<GoodCategoryService.GoodCategoryResponse, GoodCategoryDomain>,
        KafkaModelMapper<GoodCategoryKafkaModel, GoodCategoryDomain> {

    @Mapping(target = "name", source = "names", qualifiedByName = "collectText")
    GoodCategoryService.GoodCategorySearchResponse toSearchResponse(final GoodCategoryDomain entity);
}
