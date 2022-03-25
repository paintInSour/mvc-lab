package com.example.demo.service;

import com.example.demo.constant.OrderStatus;
import com.example.demo.db.entity.Order;
import com.example.demo.web.dto.OrderCartDto;

import java.util.List;

public interface OrderService {
    void createOrder(OrderCartDto orderCart, String phoneNumber);

    Order updateStatus(OrderStatus status, String id);

    Order save(Order order);

    Order get(String id);

    List<Order> getAllByPhoneNumber(String phoneNumber);

    void deleteOrder(String orderId);
}
