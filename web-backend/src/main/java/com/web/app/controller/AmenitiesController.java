package com.web.app.controller;

import com.web.app.api.AmenitiesApi;
import com.web.app.service.AmenityService;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AmenitiesController implements AmenitiesApi {

    private final AmenityService amenityService;

    @Override
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(amenityService.all());
    }
}