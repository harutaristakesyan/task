package com.web.app.mapper;


import com.web.app.mapper.properties.JobMapper;
import com.web.app.persistence.domain.amenity.AmenityDomain;
import com.web.app.service.AmenityService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface AmenityMapper extends DtoMapper<AmenityService.AmenityResponse, AmenityDomain> {
}
