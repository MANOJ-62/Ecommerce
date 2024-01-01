package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Order;
import com.ecommerce.orderservice.repository.OrderRepository;
import com.ecommerce.orderservice.service.feign.ProductFeignClient;
import org.springframework.stereotype.Service;
import com.ecommerce.productservice.model.Product;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductFeignClient productFeignClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductFeignClient productFeignClient) {
        this.orderRepository = orderRepository;
        this.productFeignClient = productFeignClient;
    }

    @Override
    public Order createOrder(Order order) {
        // Business logic
        Long productId = order.getProductId();
        Product product = productFeignClient.getProductById(productId);

        // Save order to the database
        order.setProductName(product.getName());
        return orderRepository.save(order);
    }

    // Implement other service methods
}