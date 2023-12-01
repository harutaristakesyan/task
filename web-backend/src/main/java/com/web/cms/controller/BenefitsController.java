package com.web.cms.controller;

import com.web.cms.api.BenefitsApi;
import com.web.cms.service.BenefitService;
import com.web.core.util.ResponseUtil;
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
