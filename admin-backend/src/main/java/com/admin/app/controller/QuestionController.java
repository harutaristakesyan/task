package com.admin.app.controller;

import com.admin.app.api.QuestionApi;
import com.admin.app.service.QuestionService;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController implements QuestionApi {

    private final QuestionService questionService;

    @Override
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(questionService.all());
    }
}
