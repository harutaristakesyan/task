package com.admin.app.service.impl;

import com.admin.app.mapper.OrderMapper;
import com.admin.app.persistence.repository.OrderRepository;
import com.admin.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;


    @Value("${mail.to}")
    private String mailTo;

    @Value("${mail.from}")
    private String mailFrom;

    @Override
    public OrderResponse add(final OrderRequest request) {
        var orderEntity = orderRepository.save(orderMapper.toEntity(request));

        return orderMapper.toResponse(orderEntity);
    }


}
