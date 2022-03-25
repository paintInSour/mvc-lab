package com.example.demo.service;

import com.example.demo.constant.OrderStatus;
import com.example.demo.converter.item.ItemConverter;
import com.example.demo.db.entity.Order;
import com.example.demo.db.repository.OrderRepository;
import com.example.demo.exception.NotFoundException;
import com.example.demo.web.dto.OrderCartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderCartDto orderCart, String phoneNumber) {
        var items = orderCart.getItemDtoList().stream()
                .map(ItemConverter::toEntity)
                .collect(Collectors.toList());
        var order = Order.builder()
                .items(items)
                .price(orderCart.getPrice())
                .status(OrderStatus.CREATED)
                .phoneNumber(phoneNumber
                )
                .build();
        save(order);
    }

    @Override
    public Order updateStatus(OrderStatus status, String id) {
        var order = get(id);
        order.setStatus(status);
        return save(order);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order get(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Not found order by id = %s", id)
                ));
    }

    @Override
    public List<Order> getAllByPhoneNumber(String phoneNumber) {
        return orderRepository.findAllByPhoneNumber(phoneNumber);
    }

    @Override
    public  void deleteOrder(String orderId){
        orderRepository.deleteById(orderId);
    }

}
