package com.task.ecommerce.common.handler;

import com.task.ecommerce.common.exceptions.CustomRootException;
import com.task.ecommerce.domain.common.ApiResponse;
import com.task.ecommerce.domain.enums.ResponseMessage;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@AllArgsConstructor
public class EcommerceExceptionHandler extends BaseExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public final ResponseEntity<ApiResponse<Void>> handleDBException(DataAccessException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        String rootCause = Objects.nonNull(ex.getRootCause()) ? ex.getRootCause().toString() : "";
        errorLogger.error("Root Cause: " + rootCause);
        ApiResponse<Void> apiResponse = buildApiResponse(ResponseMessage.DATABASE_EXCEPTION.getResponseCode(), ResponseMessage.DATABASE_EXCEPTION.getResponseMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(CustomRootException.class)
    public final ResponseEntity<ApiResponse<Void>> handleCustomException(CustomRootException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        ApiResponse<Void> apiResponse = buildApiResponse(ex.getMessageCode(), ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
