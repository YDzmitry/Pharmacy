package com.vironit.pharmacy.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Configuration
@Scope("request")
public class RegistrationValidatorException extends RuntimeException {

    private Map<String, String> errMessageMap;

    public RegistrationValidatorException() {
    }

    public RegistrationValidatorException(Map<String, String> errMessageMap) {
        this.errMessageMap = errMessageMap;
    }

    public Map<String, String> getErrMessageMap() {
        return errMessageMap;
    }
}
