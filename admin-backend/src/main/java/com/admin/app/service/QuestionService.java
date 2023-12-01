package com.admin.app.service;

import com.admin.core.data.AbstractListResponse;
import com.admin.core.supported.AllSupported;

public interface QuestionService extends AllSupported<AbstractListResponse<QuestionService.QuestionResponse>> {


    record QuestionResponse(String id, String description) {


    }

}
