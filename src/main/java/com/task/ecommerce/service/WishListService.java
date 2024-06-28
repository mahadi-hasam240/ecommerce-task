package com.task.ecommerce.service;

import com.task.ecommerce.domain.entity.WishList;
import com.task.ecommerce.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService implements IWishListService {
    private final WishListRepository wishListRepository;

    @Override
    public Page<WishList> getCustomerWishList(Long customerId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return wishListRepository.findByCustomerId(customerId, pageable);
    }
}
