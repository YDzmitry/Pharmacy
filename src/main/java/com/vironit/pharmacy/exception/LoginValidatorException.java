package com.vironit.pharmacy.exception;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginValidatorException extends RuntimeException{

    private Map<String,String> errMessageMap;

    public LoginValidatorException() {
    }

    public LoginValidatorException(Map<String,String> errMessageMap) {
        this.errMessageMap = errMessageMap;
    }

    public Map<String, String> getErrMessageMap() {
        return errMessageMap;
    }
}
