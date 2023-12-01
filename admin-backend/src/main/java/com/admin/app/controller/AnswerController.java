package com.admin.app.controller;

import com.admin.app.api.AnswerApi;
import com.admin.app.service.AnswerService;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AnswerController implements AnswerApi {

    private final AnswerService answerService;

    @Override
    public ResponseEntity<?> allByQuestionId(final UUID questionId) {
        return ResponseUtil.ok(answerService.get(questionId));
    }

}
