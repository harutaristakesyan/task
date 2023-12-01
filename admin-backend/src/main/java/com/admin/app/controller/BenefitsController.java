package com.admin.app.controller;

import com.admin.app.api.BenefitsApi;
import com.admin.app.service.BenefitService;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BenefitsController implements BenefitsApi {

    private final BenefitService benefitService;

    @Override
    public ResponseEntity<?> all() {
        return ResponseUtil.ok(benefitService.all());
    }
}
