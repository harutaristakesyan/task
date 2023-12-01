package com.web.app.mapper;

import com.web.app.persistence.domain.ServiceDomain;
import com.web.app.service.ServiceService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper extends DtoMapper<ServiceService.ServiceResponse, ServiceDomain> {

}
