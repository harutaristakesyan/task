package com.web.cms.service;

import com.web.core.data.AbstractListResponse;
import com.web.core.supported.AllSupported;

public interface BenefitService extends AllSupported<AbstractListResponse<BenefitService.BenefitResponse>> {

    record BenefitResponse() {
    }

}
