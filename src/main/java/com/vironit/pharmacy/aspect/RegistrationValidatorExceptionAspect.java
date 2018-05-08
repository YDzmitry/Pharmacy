package com.vironit.pharmacy.aspect;

import com.vironit.pharmacy.dto.NewRegistrationUser;
import com.vironit.pharmacy.validator.RegistrationValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RegistrationValidatorExceptionAspect {

    @Autowired
    RegistrationValidator registrationValidator;

    @Before("execution(* com.vironit.pharmacy.converter.NewRegistrationUserToUserConverter.convert(..))")
    public void validateBefore(JoinPoint joinPoint){
        NewRegistrationUser user = (NewRegistrationUser)joinPoint.getArgs()[0];
        registrationValidator.validate(user.getLogin(),user.getPassword());
    }
}
