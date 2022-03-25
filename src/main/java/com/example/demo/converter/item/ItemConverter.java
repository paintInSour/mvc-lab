package com.example.demo.converter.item;

import com.example.demo.db.entity.Item;
import com.example.demo.web.dto.ItemDto;

public final class ItemConverter {

    public static ItemDto toDto(Item item){
        return ItemDto.builder()
                .id(item.getId())
                .img(item.getImg())
                .description(item.getDescription())
                .title(item.getTitle())
                .price(item.getPrice())
                .build();
    }

    public static Item toEntity(ItemDto itemDto){
        return Item.builder()
                .id(itemDto.getId())
                .img(itemDto.getImg())
                .description(itemDto.getDescription())
                .title(itemDto.getTitle())
                .price(itemDto.getPrice())
                .build();
    }
}
