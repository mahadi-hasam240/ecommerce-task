package com.task.ecommerce.api;

import com.task.ecommerce.common.AppUtils;
import com.task.ecommerce.domain.entity.WishList;
import com.task.ecommerce.service.WishListService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL + "/wish-list")
public class WishListResource {
    private final WishListService wishListService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Page<WishList>> getCustomerWishList(@PathVariable Long customerId,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        Page<WishList> wishLists = wishListService.getCustomerWishList(customerId, page, size);
        return ResponseEntity.ok(wishLists);

    }

}