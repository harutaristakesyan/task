package com.web.app.service;


import com.web.core.data.AbstractListResponse;
import com.web.core.supported.AllSupported;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public interface AmenityService extends AllSupported<AbstractListResponse<AmenityService.AmenityResponse>> {

    record AmenityResponse(String name, List<JobResponse> jobs) implements Serializable {

        @Serial
        private static final long serialVersionUID = 2L;
    }

    record JobResponse(String name, Integer price) implements Serializable {

        @Serial
        private static final long serialVersionUID = 3L;
    }


}
