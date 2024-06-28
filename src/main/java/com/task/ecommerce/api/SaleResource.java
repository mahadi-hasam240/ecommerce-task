package com.task.ecommerce.api;

import com.task.ecommerce.common.utils.AppUtils;
import com.task.ecommerce.domain.dto.ItemSalesDto;
import com.task.ecommerce.domain.dto.ItemSalesQuantityDto;
import com.task.ecommerce.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL + "/sales")
public class SaleResource {
    private final ISaleService saleService;

    @GetMapping("/current-date-total")
    public ResponseEntity<BigDecimal> getTotalSaleAmountForCurrentDay() {
        BigDecimal totalSaleAmount = saleService.getTotalSaleOfCurrentDate();
        return ResponseEntity.ok(totalSaleAmount);
    }

    @GetMapping("/max-sale-day")
    public ResponseEntity<LocalDate> getMaxSaleDay(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime endDate) {

        LocalDate maxSaleDay = saleService.findMaxSaleDay(startDate, endDate);
        return ResponseEntity.ok(maxSaleDay);
    }

    @GetMapping("/top-selling-items")
    public ResponseEntity<List<ItemSalesDto>> getTopSellingItems() {
        List<ItemSalesDto> topSellingItems = saleService.findTopSellingItems();
        return ResponseEntity.ok(topSellingItems);
    }

    @GetMapping("/top-selling-items-last-month")
    public ResponseEntity<List<ItemSalesQuantityDto>> getTopSellingItemsOfLastMonth() {
        List<ItemSalesQuantityDto> topSellingItems = saleService.findTopSellingItemsOfLastMonth();
        return ResponseEntity.ok(topSellingItems);
    }
}
