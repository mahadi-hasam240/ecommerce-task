package com.task.ecommerce.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.ecommerce.domain.common.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseExceptionHandler {

    protected static final Logger errorLogger = LoggerFactory.getLogger("errorLogger");
    protected static final ObjectMapper mapper = new ObjectMapper();

    protected ApiResponse<Void> buildApiResponse(String messageCode, String message) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setResponseMessage(message);
        apiResponse.setResponseCode(messageCode);
        return apiResponse;
    }

    
}
