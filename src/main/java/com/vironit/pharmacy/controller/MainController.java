package com.vironit.pharmacy.controller;

import com.vironit.pharmacy.model.user.MainUser;
import com.vironit.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class MainController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody MainUser user) {
        long id = userService.save(user);
        return ResponseEntity.ok().body("New User has been saved with ID:" + id);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id) {
        MainUser user = userService.getByPK(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody MainUser user) {
        userService.update(user);
        return ResponseEntity.ok().body("User has been updated " + id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        userService.delete(id);
        return ResponseEntity.ok().body("User has been deleted" + id);
    }

}
