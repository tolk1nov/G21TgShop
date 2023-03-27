package org.example.repository.product;

import org.example.domain.model.Product;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryImpl implements ProductRepository{
    private static final ProductRepositoryImpl instance = new ProductRepositoryImpl();
    public static ProductRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public int save(Product product) {
        return 0;
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void remove(UUID id) {

    }
}
