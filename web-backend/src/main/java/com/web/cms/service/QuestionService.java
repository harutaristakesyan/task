package com.web.cms.service;

import com.web.core.data.AbstractListResponse;
import com.web.core.supported.AllSupported;

public interface QuestionService extends AllSupported<AbstractListResponse<QuestionService.QuestionResponse>> {

    record QuestionResponse(String id, String description) {

    }

}
