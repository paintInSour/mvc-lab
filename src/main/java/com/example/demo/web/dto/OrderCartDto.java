package com.example.demo.web.dto;

import com.example.demo.web.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class OrderCartDto {
    private List<ItemDto> itemDtoList;
    private Double price;

    public OrderCartDto(){
        this.itemDtoList = new ArrayList<>();
        this.price = 0D;
    }
}
