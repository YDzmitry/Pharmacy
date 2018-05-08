package com.vironit.pharmacy.validator;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Scope("prototype")
public class CreatingNewUserErrorValidator {

    private Map<String, String> errMessageMap = new HashMap<>();

    public Map<String, String> validate(Exception e){
        if (e.getCause().toString().contains("users_login_key")){
            errMessageMap.put("login","Такой пользователь уже присутствует в системе");
        }
        if (e.getCause().toString().contains("users_passport_key")){
            errMessageMap.put("passport","Такой паспорт уже присутствует в системе");
        }
        return errMessageMap;
    }
}
