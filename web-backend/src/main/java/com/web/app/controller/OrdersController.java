package com.web.app.controller;

import com.web.app.api.OrdersApi;
import com.web.app.service.OrderService;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrdersController implements OrdersApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<?> add(final OrderService.OrderRequest request) {
        return ResponseUtil.ok(orderService.add(request));
    }
}
