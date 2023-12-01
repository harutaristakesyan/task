package com.web.cms.mapper;

import com.web.cms.persistence.domain.QuestionDomain;
import com.web.cms.service.QuestionService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends DtoMapper<QuestionService.QuestionResponse, QuestionDomain> {
}
