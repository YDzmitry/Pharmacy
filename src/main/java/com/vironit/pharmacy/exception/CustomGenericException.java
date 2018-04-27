package com.vironit.pharmacy.exception;

import java.util.Map;

public class CustomGenericException extends  RuntimeException {

    public CustomGenericException() {
        super();
    }

    public CustomGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomGenericException(String message) {
        super(message);
    }

    public CustomGenericException(Throwable cause) {
        super(cause);
    }

}

