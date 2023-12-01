package com.web.app.controller;

import com.web.app.api.WorksApi;
import com.web.app.service.WorkService;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorksController implements WorksApi {

    private final WorkService workService;

    @Override
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(workService.all());
    }
}
