package com.task.ecommerce.service;

import com.task.ecommerce.common.exceptions.RecordNotFoundException;
import com.task.ecommerce.domain.dto.ItemSalesDto;
import com.task.ecommerce.domain.dto.ItemSalesQuantityDto;
import com.task.ecommerce.domain.entity.Item;
import com.task.ecommerce.domain.enums.ResponseMessage;
import com.task.ecommerce.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService{
    private final SaleRepository saleRepository;

    @Override
    public BigDecimal getTotalSaleOfCurrentDate() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDateTime.now();
        return saleRepository.getTotalSaleForCurrentDay(startOfDay, endOfDay);
    }

    @Override
    public LocalDate findMaxSaleDay(LocalDateTime startDate, LocalDateTime endDate) {
        return saleRepository.findMaxSaleDay(startDate, endDate);
    }

    @Override
    public List<ItemSalesDto> findTopSellingItems() {
        List<Object[]> results = saleRepository.findTopSellingItems(PageRequest.of(0, 5));
        if(ObjectUtils.isEmpty(results)){
            throw  new RecordNotFoundException(ResponseMessage.RECORD_NOT_FOUND);
        }
        return results.stream()
                .map(result -> new ItemSalesDto((Item) result[0], (BigDecimal) result[1]))
                .collect(Collectors.toList());
    }

    public List<ItemSalesQuantityDto> findTopSellingItemsOfLastMonth() {
        LocalDateTime startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1).atStartOfDay();
        LocalDateTime endDate = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        return saleRepository.findTopSellingItemsOfLastMonth(startDate, endDate);
    }
}
