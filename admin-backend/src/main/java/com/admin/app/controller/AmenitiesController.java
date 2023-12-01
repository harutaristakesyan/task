package com.admin.app.controller;

import com.admin.app.api.AmenitiesApi;
import com.admin.app.service.AmenityService;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AmenitiesController implements AmenitiesApi {

    private final AmenityService amenityService;

    @Override
    @PreAuthorize("hasAnyAuthority('CanViewAmenities')")
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(amenityService.all());
    }
}