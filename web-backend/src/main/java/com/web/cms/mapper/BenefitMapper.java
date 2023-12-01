package com.web.cms.mapper;

import com.web.cms.persistence.domain.BenefitDomain;
import com.web.cms.service.BenefitService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BenefitMapper extends DtoMapper<BenefitService.BenefitResponse, BenefitDomain> {
}
