package com.example.demo.web.controller.admin;

import com.example.demo.service.ItemService;
import com.example.demo.web.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ItemDto create(@RequestBody ItemDto itemDto) {
        log.info("Request to create {}", itemDto);
        var item = itemService.create(itemDto);
        log.info("Response on create {}", item);
        return item;
    }
}
