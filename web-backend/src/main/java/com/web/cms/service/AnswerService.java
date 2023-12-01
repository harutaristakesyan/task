package com.web.cms.service;

import com.web.core.data.AbstractListResponse;
import com.web.core.supported.GetSupported;
import com.web.core.supported.SearchSupported;

import java.util.UUID;

public interface AnswerService extends SearchSupported<UUID, AbstractListResponse<AnswerService.AnswerResponse>>,
        GetSupported<UUID, AbstractListResponse<AnswerService.AnswerResponse>> {

    record AnswerResponse(String id, String description) {
    }

}
