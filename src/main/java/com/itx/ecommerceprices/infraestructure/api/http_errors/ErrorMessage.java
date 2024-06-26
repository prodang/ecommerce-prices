package com.itx.ecommerceprices.infraestructure.api.http_errors;

import lombok.Getter;

@Getter
class ErrorMessage {

    private final String error;
    private final String message;
    private final Integer code;

    ErrorMessage(Exception exception, Integer code) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.code = code;
    }

}