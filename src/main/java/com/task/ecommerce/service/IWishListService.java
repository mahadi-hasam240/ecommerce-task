package com.task.ecommerce.service;

import com.task.ecommerce.domain.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWishListService {
    Page<WishList> getCustomerWishList(Long customerId, int page, int size);
}
