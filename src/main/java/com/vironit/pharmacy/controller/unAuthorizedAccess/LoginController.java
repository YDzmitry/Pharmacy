package com.vironit.pharmacy.controller.unAuthorizedAccess;


import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.LoginValidatorException;
import com.vironit.pharmacy.model.user.MainUser;
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
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> enter(@Valid @RequestBody RegistrationAndLoginUser loginUser, HttpSession httpSession) {
        MainUser user = userService.getByLoginAndPassword(loginUser);
        httpSession.setAttribute("idUser", user.getId());
        httpSession.setAttribute("roleUser", user.getRole());
        return ResponseEntity.ok().body(user);
    }

    @ExceptionHandler(LoginValidatorException.class)
    public ResponseEntity handleInvalidCredentials(LoginValidatorException ex) {
        return ResponseEntity.ok().body(ex.getErrMessageMap());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception ex) {
        return ResponseEntity.badRequest().body(HttpStatus.NOT_FOUND);
    }
    //TODO может это сделать аспектом? ControllerAdvice

}
