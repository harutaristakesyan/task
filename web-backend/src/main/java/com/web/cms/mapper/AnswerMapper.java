package com.web.cms.mapper;

import com.web.cms.persistence.domain.AnswerDomain;
import com.web.cms.service.AnswerService;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends DtoMapper<AnswerService.AnswerResponse, AnswerDomain> {
}
