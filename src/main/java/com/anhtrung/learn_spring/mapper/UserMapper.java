package com.anhtrung.learn_spring.mapper;

import com.anhtrung.learn_spring.dto.reponse.UserReponse;
import com.anhtrung.learn_spring.dto.request.UserCreationRequest;
import com.anhtrung.learn_spring.dto.request.UserUpdateRequest;
import com.anhtrung.learn_spring.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserReponse toUserReponse(User user);
}
