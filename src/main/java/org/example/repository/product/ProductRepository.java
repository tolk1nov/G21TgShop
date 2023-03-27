package org.example.repository.product;

import org.example.domain.model.Product;
import org.example.repository.BaseRepository;

public interface ProductRepository extends BaseRepository<Product> {
    String INSERT = """
            insert into products(name, price, type, amount)
            values(?, ?, ?, ?);
            """;

    String DELETE = """
            delete from products where id = ?::uuid
            """;

    String FIND_BY_ID = """
            select * from products where id = ?::uuid
            """;

    String FIND_ALL = """
            select * from products
            """;

    String UPDATE = """
            update products set price = ?, amount = ? where id = ?::uuid;
            """;

}
