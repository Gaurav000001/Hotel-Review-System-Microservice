package com.micro.user.controller;

import com.micro.user.model.User;
import com.micro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/micro/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUserHandler(@RequestBody User user){

        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsersHandler(){

        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("{userId}/")
    public ResponseEntity<User> getUserByUserIdHandler(@PathVariable String userId){

        return ResponseEntity.ok(userService.getUser(userId));
    }
}
