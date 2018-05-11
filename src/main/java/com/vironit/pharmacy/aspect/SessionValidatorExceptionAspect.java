package com.vironit.pharmacy.aspect;

import com.vironit.pharmacy.exception.CustomGenericException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class SessionValidatorExceptionAspect {

    @Before("execution(* com.vironit.pharmacy.controller.*.*(..))" +
            "&& !@target(com.vironit.pharmacy.util.NoCheckingActualSession)")
    public void validateBefore(JoinPoint joinPoint) {
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            if (joinPoint.getArgs()[i] instanceof HttpSession) {
                HttpSession httpSession = (HttpSession) joinPoint.getArgs()[i];
                try {
                    httpSession.getAttribute("idUser");
                } catch (Exception ex) {
                    throw new CustomGenericException("no authorized");
                }
            }
        }

    }
}
