package org.example.repository.basket;

import org.example.domain.DTO.BaseResponse;
import org.example.domain.model.Basket;
import org.example.repository.BaseRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface BasketRepository extends BaseRepository<Basket> {

    List<Basket> findMyBasket(UUID userId) throws SQLException;

    BaseResponse<Basket> deleteBasket(UUID userId) throws SQLException;

    String INSERT = """
            insert into baskets(product_id, user_id, amount, total_price)
            values(?::uuid, ?::uuid, ?, ?);
            """;

    String DELETE = """
            delete from baskets where id = ?::uuid
            """;

    String FIND_BY_ID = """
            select * from baskets where id = ?::uuid
            """;

    String FIND_ALL = """
            select * from baskets
            """;
    String FIND_BASKET = """
            select * from baskets where user_id = ?::uuid
            """;
    String DELETE_BASKET = """
            delete from baskets where user_id = ?::uuid
            """;


}
