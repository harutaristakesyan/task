package com.web.app.api;

import com.web.app.service.OrderService;
import com.web.core.api.AddApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/orders")
public interface OrdersApi extends AddApi<OrderService.OrderRequest, ResponseEntity<?>> {
}
