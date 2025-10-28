package com.anhtrung.learn_spring.service;

import com.anhtrung.learn_spring.dto.reponse.UserReponse;
import com.anhtrung.learn_spring.dto.request.UserCreationRequest;
import com.anhtrung.learn_spring.dto.request.UserUpdateRequest;
import com.anhtrung.learn_spring.entity.User;
import com.anhtrung.learn_spring.exception.AppException;
import com.anhtrung.learn_spring.exception.ErrorCode;
import com.anhtrung.learn_spring.mapper.UserMapper;
import com.anhtrung.learn_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public User createUser(UserCreationRequest request) {


        if(userRepository.existsByUsername(request.getUsername())) {
            throw  new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);

       return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public UserReponse getUser(String id) {
         return userMapper.toUserReponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }
    public UserReponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
       userMapper.updateUser(user, request);
        return userMapper.toUserReponse(userRepository.save(user));
    }
    public void  deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
