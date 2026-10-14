package com.ecom.eazystore.service;

import com.ecom.eazystore.dto.OrderRequestDto;
import com.ecom.eazystore.dto.OrderResponseDto;
import com.ecom.eazystore.entity.Order;

import java.util.List;

public interface IOrderService {

    void createOrder(OrderRequestDto orderRequest);

    List<OrderResponseDto> getCustomerOrders();

    List<OrderResponseDto> getAllPendingOrders();

    void updateOrderStatus(Long orderId, String orderStatus);
}