package com.admin.app.controller;

import com.admin.app.api.ServicesApi;
import com.admin.app.service.ServiceService;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServicesController implements ServicesApi {

    private final ServiceService service;

    @Override
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(service.all());
    }
}
