package com.i18n.translation.serivce.impl;

import com.i18n.translation.document.TranslationDocument;
import com.i18n.translation.mapper.TranslationMapper;
import com.i18n.translation.model.TranslationRequest;
import com.i18n.translation.model.TranslationResponse;
import com.i18n.translation.repository.TranslateRepository;
import com.i18n.translation.serivce.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {


    private final TranslationMapper translationMapper;

    private final TranslateRepository translateRepository;

    @Override
    public void add(final TranslationRequest request) {
        translateRepository.save(translationMapper.toDocument(request));
    }

    @Override
    public TranslationResponse get(final String uuid) {
        return translationMapper.toResponse(
                translateRepository.findById(uuid)
                        .orElseThrow(notFoundException(TranslationDocument.class, uuid,
                                Map.of("class", "Document", "identifier", uuid))));
    }
}
