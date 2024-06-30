package com.task.ecommerce.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseMessage {
    OPERATION_SUCCESSFUL(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode(), "operation.success"),
    RECORD_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "record.not.found"),
    INVALID_REQUEST_DATA(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "invalid.request.data"),
    DATABASE_EXCEPTION(ApiResponseCode.DB_OPERATION_FAILED.getResponseCode(), "database.exception");
    private final String responseCode;
    private final String responseMessage;
}
