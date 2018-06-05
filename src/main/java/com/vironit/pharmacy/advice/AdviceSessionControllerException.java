package com.vironit.pharmacy.advice;

import com.vironit.pharmacy.exception.CustomGenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class})
@RestController
public class AdviceSessionControllerException {

    @ExceptionHandler(CustomGenericException.class)
    public ResponseEntity handleAllException(CustomGenericException ex) {
        return ResponseEntity.ok().body(ex.getMap());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception ex) {
        return ResponseEntity.badRequest().body(ex);
    }
}
