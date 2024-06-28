package com.task.ecommerce.domain.dto;

import com.task.ecommerce.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemSalesDto {
    private Item item;
    private BigDecimal totalSaleAmount;
}
