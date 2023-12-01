package com.web.app.service;

import com.web.core.data.AbstractListResponse;
import com.web.core.supported.AllSupported;

public interface WorkService extends AllSupported<AbstractListResponse<WorkService.WorkResponse>> {

    record WorkResponse() {
    }
}
