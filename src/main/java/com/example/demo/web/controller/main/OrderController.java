package com.example.demo.web.controller.main;

import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;
import com.example.demo.web.dto.OrderCartDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Scope("session")
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final ItemService itesmService;
    private final OrderCartDto orderCart;

    @PostMapping
    public String create(Model model, @RequestParam String phoneNumber) {
        log.info("Request to create order");

        orderService.createOrder(orderCart, phoneNumber);
        orderCart.getItemDtoList().clear();
        orderCart.setPrice(0D);
        return "main";
    }

    @GetMapping
    public String history(Model model) {
        return "history";
    }

    @GetMapping("/all")
    public String history(Model model, @RequestParam String phoneNumber) {
        log.info("Request to get order history");
        var orders = orderService.getAllByPhoneNumber(phoneNumber);
        model.addAttribute("orders", orders);
        return "history";
    }

    @PostMapping("/delete")
    public String cancel(Model model, @RequestParam String orderId, @RequestParam String phoneNumber) {
        log.info("Request to delete order");
        orderService.deleteOrder(orderId);
        var orders = orderService.getAllByPhoneNumber(phoneNumber);
        model.addAttribute("orders", orders);
        return "history";
    }
}
