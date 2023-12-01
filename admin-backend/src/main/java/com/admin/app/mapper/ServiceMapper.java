package com.admin.app.mapper;

import com.admin.app.persistence.domain.ServiceDomain;
import com.admin.app.service.ServiceService;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper extends DtoMapper<ServiceService.ServiceResponse, ServiceDomain> {

    @Override
    ServiceService.ServiceResponse toResponse(ServiceDomain entity);
}
