package com.bootstrap.bootstrap.controller;

import com.bootstrap.bootstrap.model.User;
import com.bootstrap.bootstrap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Ali Veliev 21.11.2021
 */

@RestController
@RequestMapping("/")
public class UserRestController {


    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.allUsers();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return service.readUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>(service.getUserByName(user.getName()), HttpStatus.OK);
    }

    @RequestMapping(value = "/users"
            , produces = MediaType.ALL_VALUE
            , method = RequestMethod.PUT)
    public ResponseEntity<User> changeUser(@RequestBody User user) {
        service.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> changeUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
