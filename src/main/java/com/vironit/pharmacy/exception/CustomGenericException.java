package com.vironit.pharmacy.exception;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@Scope("request")
public class CustomGenericException extends RuntimeException {

    Map<String, String> map = new HashMap();

    public CustomGenericException() {
        super();
    }


    public CustomGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomGenericException(String message) {
        map.put("error",message);
    }

    public CustomGenericException(Throwable cause) {
        super(cause);
    }

    public Map<String, String> getMap() {
        return map;
    }
}

