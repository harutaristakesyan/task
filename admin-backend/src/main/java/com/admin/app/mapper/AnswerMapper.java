package com.admin.app.mapper;

import com.admin.app.data.AnswerResponse;
import com.admin.app.persistence.domain.AnswerDomain;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends DtoMapper<AnswerResponse, AnswerDomain> {
}
