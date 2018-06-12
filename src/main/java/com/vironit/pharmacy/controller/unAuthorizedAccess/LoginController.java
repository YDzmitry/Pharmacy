package com.vironit.pharmacy.controller.unAuthorizedAccess;


import com.vironit.pharmacy.exception.LoginValidatorException;
import com.vironit.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/success")
    public ResponseEntity<?> successEnter(@RequestParam ("secure") String destination) {
        Map<String,String> map = new HashMap<>();
        map.put("page",destination);
        return ResponseEntity.ok().body(map);
    }

    @GetMapping("/err")
    public ResponseEntity<?> failureEnter(@RequestParam ("secure") String destination) {
        Map<String,String> map = new HashMap<>();
        map.put("page",destination);
        return ResponseEntity.ok().body(map);
    }


    @ExceptionHandler(LoginValidatorException.class)
    public ResponseEntity handleInvalidCredentials(LoginValidatorException ex) {
        return ResponseEntity.ok().body(ex.getErrMessageMap());
    }
}
