package com.web.cms.service.impl;

import com.web.cms.mapper.AnswerMapper;
import com.web.cms.persistence.repository.AnswerRepository;
import com.web.cms.service.AnswerService;
import com.web.core.data.AbstractListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    private final AnswerRepository answerRepository;

    @Override
    public AbstractListResponse<AnswerResponse> search(final UUID questId) {
        return null;
    }

    @Override
    public AbstractListResponse<AnswerResponse> get(UUID uuid) {
        return null;
    }
}
