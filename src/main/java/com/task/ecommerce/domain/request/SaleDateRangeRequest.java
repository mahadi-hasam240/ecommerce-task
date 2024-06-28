package com.task.ecommerce.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SaleDateRangeRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
