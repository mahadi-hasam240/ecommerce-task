package com.task.ecommerce.common.exceptions;

import com.task.ecommerce.domain.enums.ResponseMessage;

public class RecordNotFoundException extends CustomRootException{
    public RecordNotFoundException(ResponseMessage responseMessage) {
        super(responseMessage);
    }
}
