package com.web.app.service.impl;

import com.web.app.mapper.OrderMapper;
import com.web.app.persistence.repository.OrderRepository;
import com.web.app.service.OrderService;
import com.web.core.client.notification.data.NotificationRequest;
import com.web.core.client.notification.data.properties.TemplateType;
import com.web.core.client.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    private final NotificationService notificationService;

    @Value("${mail.to}")
    private String mailTo;

    @Value("${mail.from}")
    private String mailFrom;

    @Override
    public OrderResponse add(final OrderRequest request) {
        var orderEntity = orderRepository.save(orderMapper.toDomain(request));

        sendNotification(request);

        return orderMapper.toDto(orderEntity);
    }

    private void sendNotification(final OrderRequest request) {
        notificationService.sendMail(new NotificationRequest(
                mailFrom, Set.of(mailTo), Set.of(), TemplateType.ORDER,
                Map.of("phoneNumber", request.phoneNumber(),
                        "name", request.name())));
    }
}
