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
public class UserRoleValidatorExceptionAspect {

    @Before("@annotation(com.vironit.pharmacy.util.AdminAccessOnly)")
    public void validateBefore() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);
        String userRole = (String) session.getAttribute("roleUser");
        if (!userRole.equals("ADMIN")) {
            throw new CustomGenericException("Restricted for your role");
        }
    }
}
