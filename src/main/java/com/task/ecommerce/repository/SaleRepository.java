package com.task.ecommerce.repository;

import com.task.ecommerce.domain.dto.ItemSalesQuantityDto;
import com.task.ecommerce.domain.entity.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT coalesce(sum (s.item.price * s.quantity), 0) " +
            " from Sale s " +
            "WHERE s.saleDate >= :startDate AND s.saleDate <= :endDate")
    BigDecimal getTotalSaleForCurrentDay(@Param("startDate") LocalDateTime startDate,
                                         @Param("endDate") LocalDateTime endDate);

    @Query("SELECT s.saleDate FROM Sale s " +
            "WHERE s.saleDate BETWEEN :startDate AND :endDate " +
            "GROUP BY s.saleDate " +
            "ORDER BY SUM(s.quantity * s.item.price) DESC " +
            "LIMIT 1")
    LocalDate findMaxSaleDay(@Param("startDate") LocalDateTime startDate,
                             @Param("endDate") LocalDateTime endDate);

    @Query("SELECT s.item, SUM(s.quantity * s.item.price) as totalSaleAmount " +
            "FROM Sale s " +
            "GROUP BY s.item " +
            "ORDER BY totalSaleAmount DESC")
    List<Object[]> findTopSellingItems(Pageable pageable);

    @Query("SELECT new com.task.ecommerce.domain.dto.ItemSalesQuantityDto(s.item, SUM(s.quantity)) " +
            "FROM Sale s " +
            "WHERE s.saleDate BETWEEN :startDate AND :endDate " +
            "GROUP BY s.item " +
            "ORDER BY SUM(s.quantity) DESC")
    List<ItemSalesQuantityDto> findTopSellingItemsOfLastMonth(@Param("startDate") LocalDateTime startDate,
                                                                  @Param("endDate") LocalDateTime endDate);

}
