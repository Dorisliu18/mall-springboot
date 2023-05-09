package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
