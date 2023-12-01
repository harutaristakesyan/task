package com.admin.app.mapper;

import com.admin.app.mapper.properties.JobMapper;
import com.admin.app.persistence.domain.amenity.AmenityDomain;
import com.admin.app.service.AmenityService;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface AmenityMapper extends DtoMapper<AmenityService.AmenityResponse, AmenityDomain> {
}
