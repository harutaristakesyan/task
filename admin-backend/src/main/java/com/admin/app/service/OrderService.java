package com.admin.app.service;

import com.admin.core.supported.AddSupported;

public interface OrderService extends AddSupported<OrderService.OrderRequest, OrderService.OrderResponse> {

    record OrderRequest(String name, String phoneNumber) {
    }


    record OrderResponse(String name, String phoneNumber) {
    }

}
