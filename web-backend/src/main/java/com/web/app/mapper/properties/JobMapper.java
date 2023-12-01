package com.web.app.mapper.properties;

import com.web.app.persistence.domain.amenity.properties.JobDomain;
import com.web.app.service.AmenityService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper extends DtoMapper<AmenityService.JobResponse, JobDomain> {
}
