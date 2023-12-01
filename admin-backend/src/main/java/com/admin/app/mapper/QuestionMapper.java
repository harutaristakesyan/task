package com.admin.app.mapper;

import com.admin.app.persistence.domain.QuestionDomain;
import com.admin.app.service.QuestionService;
import com.admin.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends DtoMapper<QuestionService.QuestionResponse, QuestionDomain> {
}
