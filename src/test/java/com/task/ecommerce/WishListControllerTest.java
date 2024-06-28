package com.task.ecommerce;

import com.task.ecommerce.api.WishListResource;
import com.task.ecommerce.common.AppUtils;
import com.task.ecommerce.domain.entity.Customer;
import com.task.ecommerce.domain.entity.Item;
import com.task.ecommerce.domain.entity.WishList;
import com.task.ecommerce.service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@WebMvcTest(WishListResource.class)  // Example controller to test
@AutoConfigureMockMvc
public class WishListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishListService wishlistService; // Mocking the service instead of repository

    @Test
    public void testGetWishlist() throws Exception {
        Customer customer = new Customer(1L, "John Doe", "john@example.com");
        Item item1 = new Item(1L, "Item1", BigDecimal.valueOf(19.99));
        Item item2 = new Item(2L, "Item2", BigDecimal.valueOf(29.99));
        List<WishList> wishlists = new ArrayList<>();
        wishlists.add(new WishList(1L, customer, item1));
        wishlists.add(new WishList(2L, customer, item2));
        Page<WishList> mockWishlistPage = new PageImpl<>(wishlists, PageRequest.of(0, 10), wishlists.size());

        // Mock service method
        when(wishlistService.getCustomerWishList(eq(1L), anyInt(), anyInt())).thenReturn(mockWishlistPage);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/wish-list/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].item.name").value("Item1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].item.name").value("Item2"));

    }
}
