package com.admin.app.mapper;

import com.admin.app.persistence.domain.OrderDomain;
import com.admin.app.service.OrderService;
import com.admin.core.mapper.DtoMapper;
import com.admin.core.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends DtoMapper<OrderService.OrderResponse, OrderDomain>, EntityMapper<OrderService.OrderRequest, OrderDomain> {
}
