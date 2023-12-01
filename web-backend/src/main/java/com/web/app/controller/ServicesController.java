package com.web.app.controller;

import com.web.app.api.ServicesApi;
import com.web.app.service.ServiceService;
import com.web.core.util.ResponseUtil;
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
