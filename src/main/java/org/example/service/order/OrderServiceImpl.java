package org.example.service.order;

import org.example.repository.order.OrderRepository;
import org.example.repository.order.OrderRepositoryImpl;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();
}
