package com.admin.app.mapper;

import com.admin.app.data.BenefitResponse;
import com.admin.app.persistence.domain.BenefitDomain;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BenefitMapper extends DtoMapper<BenefitResponse, BenefitDomain> {
}
