package org.example.repository.order;

import org.example.domain.model.Order;
import org.example.repository.BaseRepository;

public interface OrderRepository extends BaseRepository<Order> {
    String INSERT = """
            insert into orders(product_id, user_id, amount, total_price, status)
            values(?::uuid, ?::uuid, ?, ?, ?);
            """;

    String DELETE = """
            delete from orders where id = ?::uuid
            """;

    String FIND_BY_ID = """
            select * from orders where id = ?::uuid
            """;

    String FIND_ALL = """
            select * from orders
            """;

    String UPDATE = """
            update orders set status = ? where id = ?::uuid
            """;
}
