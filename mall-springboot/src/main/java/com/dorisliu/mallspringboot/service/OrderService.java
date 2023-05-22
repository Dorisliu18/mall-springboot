package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.dto.CreateOrderRequest;
import com.dorisliu.mallspringboot.dto.OrderQueryParams;
import model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
