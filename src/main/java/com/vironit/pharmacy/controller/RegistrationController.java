package com.vironit.pharmacy.controller;


import com.vironit.pharmacy.converter.NewRegistrationUserToUserConverter;
import com.vironit.pharmacy.dto.NewRegistrationUser;
import com.vironit.pharmacy.model.User;
import com.vironit.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class RegistrationController {

    @Autowired
    UserService userService;
    @Autowired
    NewRegistrationUserToUserConverter converter;

    @PostMapping("/createNewUser")
    public ResponseEntity<?> save(@Valid @RequestBody NewRegistrationUser newRegistrationUser) {
        User user = converter.convert(newRegistrationUser);
        long id = userService.save(user);
        return ResponseEntity.ok().body("New User has been saved with ID:" + id);
    }


    //TODO валидация с помощью аспектов
}
