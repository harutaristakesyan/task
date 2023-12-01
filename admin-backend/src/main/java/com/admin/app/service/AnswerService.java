package com.admin.app.service;

import com.admin.app.data.AnswerResponse;
import com.admin.core.data.AbstractListResponse;
import com.admin.core.supported.GetSupported;

import java.util.UUID;

public interface AnswerService extends GetSupported<UUID, AbstractListResponse<AnswerResponse>> {
}
