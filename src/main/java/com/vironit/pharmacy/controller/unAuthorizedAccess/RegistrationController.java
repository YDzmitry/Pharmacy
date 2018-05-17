package com.vironit.pharmacy.controller.unAuthorizedAccess;


import com.vironit.pharmacy.converter.NewRegistrationUserToUserConverter;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.RegistrationValidatorException;
import com.vironit.pharmacy.model.user.MainUser;
import com.vironit.pharmacy.service.UserService;
import com.vironit.pharmacy.util.NoCheckingActualSession;
import com.vironit.pharmacy.validator.CreatingNewUserErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@NoCheckingActualSession
@CrossOrigin
@RestController
public class RegistrationController {

    @Autowired
    UserService userService;
    @Autowired
    NewRegistrationUserToUserConverter converter;
    @Autowired
    CreatingNewUserErrorValidator creatingNewUserErrorValidator;

    @PostMapping("/createNewUser")
    public ResponseEntity<?> saveNewRegistrationUser(@Valid @RequestBody RegistrationAndLoginUser newRegistrationUser) {
        MainUser user = converter.convert(newRegistrationUser);
        userService.save(user);
        return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
        //TODO что возвращать?
    }

    @ExceptionHandler(RegistrationValidatorException.class)
    public ResponseEntity<?> handleRegistrationValidatorException(RegistrationValidatorException ex) {
        return ResponseEntity.ok().body(ex.getErrMessageMap());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handlePSQLException(Exception ex) {
        return ResponseEntity.ok().body(creatingNewUserErrorValidator.validate(ex));
    }

}
