package com.vironit.pharmacy.controller.unAuthorizedAccess;

import com.vironit.pharmacy.util.NoCheckingActualSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
@NoCheckingActualSession
@CrossOrigin
@RestController
public class LogOutController {


    @PostMapping("/logout")
    public ResponseEntity<?> logOut() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);
        session.invalidate();
        return ResponseEntity.ok().body("Session Invalidate");
    }
}
