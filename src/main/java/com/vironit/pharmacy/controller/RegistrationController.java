package com.vironit.pharmacy.controller;


import com.vironit.pharmacy.converter.NewRegistrationUserToUserConverter;
import com.vironit.pharmacy.dto.NewRegistrationUser;
import com.vironit.pharmacy.exception.RegistrationValidatorException;
import com.vironit.pharmacy.model.User;
import com.vironit.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@Scope("request")
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

    @ExceptionHandler(RegistrationValidatorException.class)
    public ResponseEntity<?> handleRegistrationValidatorException(RegistrationValidatorException ex){
        return ResponseEntity.ok().body(ex.getErrMessageMap());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }




    //TODO валидация с помощью аспектов

    //TODO exceptionHandler

    //спросить насчет Scope  бинов
}
