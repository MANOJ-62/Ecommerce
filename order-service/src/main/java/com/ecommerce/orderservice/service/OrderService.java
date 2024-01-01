package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Order;

public interface OrderService {
    Order createOrder(Order order);

    // Other service methods
}