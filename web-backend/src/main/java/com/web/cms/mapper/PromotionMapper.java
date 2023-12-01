package com.web.cms.mapper;

import com.web.cms.persistence.domain.PromotionDomain;
import com.web.cms.service.PromotionsService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper extends DtoMapper<PromotionsService.PromotionResponse, PromotionDomain> {
}
