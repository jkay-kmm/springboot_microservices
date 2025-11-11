package com.anhtrung.learn_spring.controller;

import com.anhtrung.learn_spring.dto.reponse.AuthenticationReponse;
import com.anhtrung.learn_spring.dto.request.ApiResponse;
import com.anhtrung.learn_spring.dto.request.AuthenticationRequest;
import com.anhtrung.learn_spring.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    private final RestClient.Builder builder;

    @PostMapping("/login-in")
    ApiResponse<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest request) {
       boolean result =  authenticationService.authenticate(request);
       return ApiResponse.<AuthenticationReponse>builder()
               .result(AuthenticationReponse.builder()
                       .authenticated(result)
                       .build())
               .build();
    }
}
