package com.web.app.mapper;

import com.web.app.persistence.domain.OrderDomain;
import com.web.app.service.OrderService;
import com.web.core.mapper.DomainMapper;
import com.web.core.mapper.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends DtoMapper<OrderService.OrderResponse, OrderDomain>, DomainMapper<OrderService.OrderRequest, OrderDomain> {
}
