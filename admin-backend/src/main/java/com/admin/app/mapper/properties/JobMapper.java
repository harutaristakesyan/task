package com.admin.app.mapper.properties;

import com.admin.app.persistence.domain.amenity.properties.JobDomain;
import com.admin.app.service.AmenityService;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper extends DtoMapper<AmenityService.JobResponse, JobDomain> {
}
