package com.admin.app.mapper;

import com.admin.app.data.WorkResponse;
import com.admin.app.persistence.domain.WorkDomain;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkMapper extends DtoMapper<WorkResponse, WorkDomain> {

}
