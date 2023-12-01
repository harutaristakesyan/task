package com.web.app.service;

import com.web.core.supported.AddSupported;

import java.io.Serializable;

public interface OrderService extends AddSupported<OrderService.OrderRequest, OrderService.OrderResponse> {

    record OrderRequest(String name, String phoneNumber) {
    }

    record OrderResponse(String name, String phoneNumber) implements Serializable {
    }


}
