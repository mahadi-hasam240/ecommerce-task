package com.task.ecommerce.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiResponseCode {
    OPERATION_SUCCESSFUL("S100000"),
    RECORD_NOT_FOUND("E000101"),
    DB_OPERATION_FAILED("E000010"),
    INVALID_REQUEST_DATA("E000102");
    public String responseCode;
}
