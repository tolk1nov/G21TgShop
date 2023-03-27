package org.example.service.basket;

import org.example.domain.DTO.BaseResponse;
import org.example.repository.basket.BasketRepository;
import org.example.repository.basket.BasketRepositoryImpl;

import java.util.UUID;

public class BasketServiceImpl implements BasketService{
    private final BasketRepository basketRepository = BasketRepositoryImpl.getInstance();
    @Override
    public BaseResponse save(Object o) {
        return null;
    }

    @Override
    public BaseResponse getById(UUID id) {
        return null;
    }
}
