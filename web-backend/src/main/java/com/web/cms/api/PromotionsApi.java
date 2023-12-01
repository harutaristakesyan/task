package com.web.cms.api;

import com.web.cms.service.criteria.PromotionsSearchParameters;
import com.web.core.api.SearchApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/promotions")
public interface PromotionsApi extends SearchApi<PromotionsSearchParameters, ResponseEntity<?>> {

}
