package com.web.cms.service;

import com.web.core.data.AbstractListResponse;
import com.web.core.supported.AllSupported;

public interface ContactService extends AllSupported<AbstractListResponse<ContactService.ContactResponse>> {

    record ContactResponse() {
    }

}
