package com.task.ecommerce.repository;

import com.task.ecommerce.domain.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishListRepository extends JpaRepository<WishList, Integer> {
    Page<WishList> findByCustomerId(Long customerId, Pageable pageable);
}
