package com.task.ecommerce.domain.dto;

import com.task.ecommerce.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemSalesQuantityDto {
    private Item item;
    private Long totalQuantity;
}
