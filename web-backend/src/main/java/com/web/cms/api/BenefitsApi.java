package com.web.cms.api;

import com.web.core.api.AllApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/benefits")
public interface BenefitsApi extends AllApi<ResponseEntity<?>> {

}
