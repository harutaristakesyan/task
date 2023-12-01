package com.web.cms.service.impl;

import com.web.cms.mapper.QuestionMapper;
import com.web.cms.persistence.repository.QuestionRepository;
import com.web.cms.service.QuestionService;
import com.web.core.data.AbstractListResponse;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;

    private final QuestionRepository questionRepository;

    @Override
    public AbstractListResponse<QuestionResponse> all() {

        final List<QuestionResponse> questionResponseList = questionRepository.findAll().stream()
                .map(questionMapper::toDto)
                .toList();

        return ResponseUtil.build(questionResponseList.size(), questionResponseList);
    }
}
