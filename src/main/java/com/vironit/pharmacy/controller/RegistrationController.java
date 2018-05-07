package com.vironit.pharmacy.controller;


import com.vironit.pharmacy.dto.NewRegistrationUser;
import com.vironit.pharmacy.model.User;
import com.vironit.pharmacy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.convert.ConversionService;

import javax.validation.Valid;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class RegistrationController {


    private final UserService userService;
    private final ConversionService conversionService;


    @PostMapping("/createNewUser")
    public ResponseEntity<?> save(@Valid @RequestBody NewRegistrationUser newRegistrationUser) {
        User user = conversionService.convert(newRegistrationUser,User.class);
        long id = userService.save(user);
        return ResponseEntity.ok().body("New User has been saved with ID:" + id);
    }

}
