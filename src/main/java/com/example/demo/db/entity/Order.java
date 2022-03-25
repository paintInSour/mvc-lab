package com.example.demo.db.entity;


import com.example.demo.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    @Id
    private String id;
    private Double price;
    private List<Item> items;
    private String phoneNumber;
    private OrderStatus status;
}
