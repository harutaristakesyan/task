package com.web.app.service;

import com.web.core.data.AbstractListResponse;
import com.web.core.supported.AllSupported;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

public interface ServiceService extends AllSupported<AbstractListResponse<ServiceService.ServiceResponse>> {

    @Getter
    @Setter
    @NoArgsConstructor
    class ServiceResponse implements Serializable {

        @Serial
        private static final long serialVersionUID = 112312312312L;

        private String name;

        private Integer price;

    }

}
