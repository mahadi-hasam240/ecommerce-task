package com.task.ecommerce;

import com.task.ecommerce.api.SaleResource;
import com.task.ecommerce.api.WishListResource;
import com.task.ecommerce.domain.entity.Customer;
import com.task.ecommerce.domain.entity.Item;
import com.task.ecommerce.domain.entity.WishList;
import com.task.ecommerce.service.SaleService;
import com.task.ecommerce.service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(SaleResource.class)  // Example controller to test
@AutoConfigureMockMvc
public class SaleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaleService saleService;

    @Test
    public void testGetTotalSaleForCurrentDate() throws Exception {
        BigDecimal expectedAmount = BigDecimal.valueOf(100.00);
        when(saleService.getTotalSaleOfCurrentDate()).thenReturn(expectedAmount);

        // Perform GET request and validate response
        mockMvc.perform(get("/api/v1/sales/current-date-total")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(expectedAmount.toString()));


    }
}
