package com.web.cms.controller;


import com.web.cms.api.AnswerApi;
import com.web.cms.service.AnswerService;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AnswerController implements AnswerApi {

    private final AnswerService answerService;

    public ResponseEntity<?> allByQuestionId(final UUID questionId) {
        return ResponseUtil.ok(answerService.get(questionId));
    }

}
