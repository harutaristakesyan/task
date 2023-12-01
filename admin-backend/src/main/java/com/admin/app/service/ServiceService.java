package com.admin.app.service;

import com.admin.core.data.AbstractListResponse;
import com.admin.core.supported.AllSupported;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public interface ServiceService extends AllSupported<AbstractListResponse<ServiceService.ServiceResponse>> {


    record ServiceResponse(String name, BigDecimal price) implements Serializable {

        @Serial
        private static final long serialVersionUID = 112312312312L;


    }
}
