package com.vironit.pharmacy.validator;

import com.vironit.pharmacy.errorMessageBundle.BundleMessage;
import com.vironit.pharmacy.exception.RegistrationValidatorException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Configuration
@Scope("prototype")
public class RegistrationValidator {


    private Map<String, String> errMessageMap = new HashMap<>();
    /*Буквы, цифры, дефисы и подчёркивания, от 4 до 16 символов.*/
    private static final String LOGIN = "^[a-z0-9_-]{4,16}$";
    /*Буквы, цифры, дефисы и подчёркивания, от 6 до 18 символов.*/
    private static final String PASSWORD = "^[a-z0-9_-]{6,18}$";
    /*Первые 2 символа заглавные буквы и последние 7 символов цифры*/
    private static final String PASSPORT = "^([A-Z]{2}[0-9]{7})?$";


    public void validate(String login, String password, String passport) throws RegistrationValidatorException {
        Pattern patternLogin = Pattern.compile(LOGIN);
        Pattern patternPassword = Pattern.compile(PASSWORD);
        Pattern patternPassport = Pattern.compile(PASSPORT);
        if (!patternLogin.matcher(login).matches()) {
            errMessageMap.put("login", BundleMessage.resourceBundle.getString("incorrectRegistrationLogin"));
        }
        if (!patternPassword.matcher(password).matches()) {
            errMessageMap.put("password", BundleMessage.resourceBundle.getString("incorrectRegistrationPassword"));
        }
        if (!patternPassport.matcher(passport).matches()) {
            errMessageMap.put("passport", BundleMessage.resourceBundle.getString("incorrectRegistrationPassport"));
        }
        if (!errMessageMap.isEmpty()) {
            throw new RegistrationValidatorException(errMessageMap);
        }
    }
}
