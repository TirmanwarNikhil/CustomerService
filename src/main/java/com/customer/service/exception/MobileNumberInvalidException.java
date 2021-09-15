package com.customer.service.exception;

import com.fasterxml.jackson.databind.ser.Serializers;

public class MobileNumberInvalidException extends BaseException {

    private static final long serialVersionUID = 1L;

    public MobileNumberInvalidException(String errorCode,String status, String message) {
        super("MobileNumberInvalidException", errorCode, status,message);
    }


}
