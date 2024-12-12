package com.dev.spring_boot_app.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "orders") // Specifies the MongoDB collection name
public class Order {
    @Id
    @Indexed(unique = true)
    private String orderId;


    private String orderDate;
    private String totalAmount;

    public Order(String orderId, String orderDate, String totalAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }
}
