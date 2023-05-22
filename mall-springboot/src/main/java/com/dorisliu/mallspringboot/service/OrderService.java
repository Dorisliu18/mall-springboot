package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.dto.CreateOrderRequest;
import model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
