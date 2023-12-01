package com.admin.app.service.impl;

import com.admin.app.mapper.QuestionMapper;
import com.admin.app.persistence.repository.QuestionRepository;
import com.admin.app.service.QuestionService;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.util.ResponseUtil;
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
                .map(questionMapper::toResponse)
                .toList();

        return ResponseUtil.build(questionResponseList.size(), questionResponseList);
    }
}
