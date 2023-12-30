package com.example.sampleproject.controller;

import com.example.sampleproject.model.Application;
import com.example.sampleproject.model.User;
import com.example.sampleproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.AddUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("create user successfully");
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody String username, @RequestBody String password){
        userService.login(username,password);
        return ResponseEntity.ok(userService.login(username,password));
    }
    @PostMapping("/{userId}/applications")
    public ResponseEntity<Application> createApplication(@PathVariable("userId") Long userId,
                                                         @RequestBody String applicationName){

        Application createdApp = userService.createApplication(userId, applicationName);
        return ResponseEntity.ok(createdApp);

    }

}
