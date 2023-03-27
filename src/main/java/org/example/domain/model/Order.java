package org.example.domain.model;

import java.util.UUID;

public class Order extends BaseModel{

    private UUID productId;
    private UUID userId;
    private Integer amount;
    private Double totalPrice;
    private OrderStatus status;
}
