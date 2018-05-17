package com.vironit.pharmacy.aspect;

import com.vironit.pharmacy.exception.CustomGenericException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class SessionValidatorExceptionAspect {

    @Before("execution(* com.vironit.pharmacy.controller..*(..))" +
            "&& !@target(com.vironit.pharmacy.util.NoCheckingActualSession)")
    public void validateBeforeAccessToAuthorizedResources() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);
        try {
            session.getAttribute("idUser");
        } catch (Exception ex) {
            throw new CustomGenericException("no authorized");
        }
    }
}

