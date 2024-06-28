package com.task.ecommerce.service;

import com.task.ecommerce.domain.dto.ItemSalesDto;
import com.task.ecommerce.domain.dto.ItemSalesQuantityDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ISaleService {
    BigDecimal getTotalSaleOfCurrentDate();
    LocalDate findMaxSaleDay(LocalDateTime startDate, LocalDateTime endDate);

    List<ItemSalesDto> findTopSellingItems();
    List<ItemSalesQuantityDto> findTopSellingItemsOfLastMonth();


}
