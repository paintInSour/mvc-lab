package com.example.demo.web.controller.main;

import com.example.demo.service.ItemService;
import com.example.demo.web.dto.ItemDto;
import com.example.demo.web.dto.OrderCartDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class ShopController {
    private final ItemService itemService;
    private final OrderCartDto orderCart;

    @GetMapping("/items")
    public String main(Model model) {
        model.addAttribute("sessionId", UUID.randomUUID().toString());
        model.addAttribute("items", itemService.getAll());
        if (orderCart.getItemDtoList() != null) {
            model.addAttribute("cart", orderCart);
        } else {
            model.addAttribute("cart", new OrderCartDto());
        }
        return "main";
    }

    @PostMapping("/cart/add")
    public String addToCart(Model model, @RequestParam String itemId) {
        log.info("id = {}", itemId);
        var item = itemService.get(itemId);
        orderCart.getItemDtoList().add(item);
        var price = orderCart.getItemDtoList().stream()
                .map(ItemDto::getPrice)
                .reduce(Double::sum)
                .orElse(0D);
        orderCart.setPrice(price);

        model.addAttribute("items", itemService.getAll());
        return "main";
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", orderCart.getItemDtoList());
        model.addAttribute("price", orderCart.getPrice());
        return "cart";
    }
}
