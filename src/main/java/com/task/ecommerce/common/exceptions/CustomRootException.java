package com.task.ecommerce.common.exceptions;

import com.task.ecommerce.domain.enums.ResponseMessage;
import lombok.Getter;

@Getter
public abstract class CustomRootException extends RuntimeException {

    private String messageCode;

    public CustomRootException(ResponseMessage responseMessage) {
        super(responseMessage.getResponseMessage());
        this.messageCode = responseMessage.getResponseCode();
    }

    public CustomRootException(String message) {
        super(message);
    }
}
