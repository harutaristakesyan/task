package com.web.app.mapper;


import com.web.app.persistence.domain.WorkDomain;
import com.web.app.service.WorkService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkMapper extends DtoMapper<WorkService.WorkResponse, WorkDomain> {

}
