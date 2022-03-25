package com.example.demo.service;

import com.example.demo.web.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto create(ItemDto itemDto);

    ItemDto update(ItemDto itemDto);

    ItemDto get(String id);

    List<ItemDto> getAll();
}
