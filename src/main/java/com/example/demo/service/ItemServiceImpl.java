package com.example.demo.service;

import com.example.demo.converter.item.ItemConverter;
import com.example.demo.db.repository.ItemRepository;
import com.example.demo.exception.NotFoundException;
import com.example.demo.web.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public ItemDto create(ItemDto itemDto) {
        var item = ItemConverter.toEntity(itemDto);
        item = itemRepository.save(item);
        return ItemConverter.toDto(item);
    }

    @Override
    public ItemDto update(ItemDto itemDto) {
        var item = ItemConverter.toEntity(itemDto);
        item = itemRepository.save(item);
        return ItemConverter.toDto(item);
    }

    @Override
    public ItemDto get(String id) {
        var item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Not found item by id = %s", id)
                ));
        return ItemConverter.toDto(item);
    }

    @Override
    public List<ItemDto> getAll() {
        return itemRepository.findAll().stream()
                .map(ItemConverter::toDto)
                .collect(Collectors.toList());
    }
}
