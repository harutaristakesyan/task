package com.admin.app.service.impl;

import com.admin.app.data.AnswerResponse;
import com.admin.app.mapper.AnswerMapper;
import com.admin.app.persistence.repository.AnswerRepository;
import com.admin.app.service.AnswerService;
import com.admin.core.data.AbstractListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    private final AnswerRepository answerRepository;

    @Override
    public AbstractListResponse<AnswerResponse> get(final UUID questId) {
        return null;
    }
}
