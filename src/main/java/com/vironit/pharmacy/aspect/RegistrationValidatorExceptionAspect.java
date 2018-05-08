package com.vironit.pharmacy.aspect;

import com.vironit.pharmacy.model.User;
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

    @Before("execution(* com.vironit.pharmacy.service.UserService.save(..))")
    public void validateBefore(JoinPoint joinPoint){
        System.out.println(12);
        User user = (User)joinPoint.getArgs()[0];
        System.out.println(12);
        // registrationValidator.validate();
    }
}
