package com.vironit.pharmacy.validator;

import com.vironit.pharmacy.errorMessageBundle.BundleMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Configuration
@Scope("prototype")
public class CreatingNewUserErrorValidator {

    private Map<String, String> errMessageMap = new HashMap<>();

    public Map<String, String> validate(Exception e) {
        if (e.getCause().getCause().toString().contains("users_login_key")) {
            errMessageMap.put("login", BundleMessage.resourceBundle.getString("existRegistrationLogin"));
        }
        if (e.getCause().getCause().toString().contains("users_passport_key")) {
            errMessageMap.put("passport", BundleMessage.resourceBundle.getString("existRegistrationPassport"));
        }
        return errMessageMap;
    }
}
