package com.vironit.pharmacy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@CrossOrigin
@Component
public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RedirectStrategy redirectStrategy;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
            try {
                if (authority.getAuthority().equals("CUSTOMER")) {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/success?secure=customer_home_page");
                } else if (authority.getAuthority().equals("ADMIN")) {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/success?secure=admin_home_page");
                } else if (authority.getAuthority().equals("MANAGER")) {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/success?secure=manager_home_page");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}