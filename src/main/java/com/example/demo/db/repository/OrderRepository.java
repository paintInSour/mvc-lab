package com.example.demo.db.repository;

import com.example.demo.db.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByPhoneNumber(String phoneNumber);
}
