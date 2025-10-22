package com.anhtrung.learn_spring.controller;

import com.anhtrung.learn_spring.dto.request.UserCreationRequest;
import com.anhtrung.learn_spring.dto.request.UserUpdateRequest;
import com.anhtrung.learn_spring.entity.User;
import com.anhtrung.learn_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
    @GetMapping
    List<User> getAllUsers() {
      return   userService.getUsers();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
   User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }

}
