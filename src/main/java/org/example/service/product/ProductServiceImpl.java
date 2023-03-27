package org.example.service.product;

import org.example.repository.product.ProductRepository;
import org.example.repository.product.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository = ProductRepositoryImpl.getInstance();
}
