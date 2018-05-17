package com.vironit.pharmacy.validator;

import com.vironit.pharmacy.errorMessageBundle.BundleMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Configuration
public class CreatingNewUserErrorValidator {

    private Map<String, String> errMessageMap = new HashMap<>();

    public Map<String, String> validate(Exception e) {
        if (((DataIntegrityViolationException) e).getRootCause().toString().contains("users_login_key")) {
            errMessageMap.put("login", BundleMessage.resourceBundle.getString("existRegistrationLogin"));
        }
        return errMessageMap;
    }
}
