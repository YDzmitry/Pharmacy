package com.vironit.pharmacy.controller.unAuthorizedAccess;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class LogOutController {

    @PostMapping("/logout")
    public ResponseEntity<?> logOut(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().body("Session Invalidate");
    }
}
