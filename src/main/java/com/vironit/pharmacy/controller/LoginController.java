package com.vironit.pharmacy.controller;


import com.vironit.pharmacy.converter.NewRegistrationUserToUserConverter;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.RegistrationValidatorException;
import com.vironit.pharmacy.model.User;
import com.vironit.pharmacy.service.UserService;
import com.vironit.pharmacy.util.NoCheckingActualSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@NoCheckingActualSession
@CrossOrigin
@Scope("request")
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> enter(@Valid @RequestBody RegistrationAndLoginUser loginUser, HttpSession httpSession) {
        User user = userService.getByLoginAndPassword(loginUser);
        httpSession.setAttribute("idUser",user.getId());
        httpSession.setAttribute("roleUser",user.getRole());
        return ResponseEntity.ok().body(httpSession);
    }

}
