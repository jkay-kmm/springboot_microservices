package com.anhtrung.learn_spring.service;

import com.anhtrung.learn_spring.dto.request.UserCreationRequest;
import com.anhtrung.learn_spring.dto.request.UserUpdateRequest;
import com.anhtrung.learn_spring.entity.User;
import com.anhtrung.learn_spring.exception.AppException;
import com.anhtrung.learn_spring.exception.ErrorCode;
import com.anhtrung.learn_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())) {
            throw  new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setBirthday(request.getBirthday());
       return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(String id) {
         return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setBirthday(request.getBirthday());
        return userRepository.save(user);
    }
    public void  deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
