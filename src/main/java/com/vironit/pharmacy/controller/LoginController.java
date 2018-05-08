package com.vironit.pharmacy.controller;


import com.vironit.pharmacy.converter.NewRegistrationUserToUserConverter;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.model.User;
import com.vironit.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@Scope("request")
@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    NewRegistrationUserToUserConverter converter;

    @PostMapping("/login")
    public ResponseEntity<?> enter(@Valid @RequestBody RegistrationAndLoginUser loginUser) {
        long id = userService.getByLoginAndPassword(loginUser);
        return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
        //TODO что возвращать?
    }
}
