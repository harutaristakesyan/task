package com.admin.app.controller;

import com.admin.app.api.WorksApi;
import com.admin.app.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorksController implements WorksApi {

    private final WorkService workService;

    @Override
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(workService.all());
    }
}
