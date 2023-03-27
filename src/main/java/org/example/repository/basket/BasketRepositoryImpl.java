package org.example.repository.basket;


import org.example.domain.DTO.BaseResponse;
import org.example.domain.model.Basket;
import org.example.util.BeanUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BasketRepositoryImpl implements BasketRepository {
    private static final BasketRepositoryImpl instance = new BasketRepositoryImpl();

    public static BasketRepositoryImpl getInstance() {
        return instance;
    }

    private final Connection connection = BeanUtil.getConnection();


    @Override
    public int save(Basket basket) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(INSERT);
            insertStatement.setString(1, basket.getProductId().toString());
            insertStatement.setString(2, basket.getUserId().toString());
            insertStatement.setInt(3, basket.getAmount());
            insertStatement.setDouble(4, basket.getTotalPrice());

            insertStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 200;
    }


    @Override
    public Optional<Basket> getById(UUID id) {
        try {
            PreparedStatement getById = connection.prepareStatement(FIND_BY_ID);
            getById.setString(1, id.toString());
            ResultSet set = getById.executeQuery();

            if (set.next()){
                return Optional.of(Basket.map(set));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Basket update(Basket basket) {
        return null;
    }

    @Override
    public void remove(Basket basket) {

    }


    @Override
    public void remove(UUID id) {

    }

    @Override
    public List<Basket> findMyBasket(UUID userId) throws SQLException {
        return null;
    }

    @Override
    public BaseResponse<Basket> deleteBasket(UUID userId) throws SQLException {
        return null;
    }
}
