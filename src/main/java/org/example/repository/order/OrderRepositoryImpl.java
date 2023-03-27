package org.example.repository.order;

import org.example.domain.model.Order;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository{
    private static final OrderRepositoryImpl instance = new OrderRepositoryImpl();
    public static OrderRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public int save(Order order) {
        return 0;
    }

    @Override
    public Optional<Order> getById(UUID id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void remove(Order order) {

    }

    @Override
    public void remove(UUID id) {

    }
}
