package com.anhtrung.learn_spring.controller;

import com.anhtrung.learn_spring.dto.reponse.AuthenticationReponse;
import com.anhtrung.learn_spring.dto.reponse.IntrospectReponse;
import com.anhtrung.learn_spring.dto.request.ApiResponse;
import com.anhtrung.learn_spring.dto.request.AuthenticationRequest;
import com.anhtrung.learn_spring.dto.request.IntrospectRequest;
import com.anhtrung.learn_spring.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    private final RestClient.Builder builder;

    @PostMapping("/token")
    ApiResponse<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest request) {
       var result =  authenticationService.authenticate(request);
       return ApiResponse.<AuthenticationReponse>builder()
               .result(result)
               .build();
    }
    @PostMapping("/introspect")
    ApiResponse<IntrospectReponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result =  authenticationService.introspect(request);
        return ApiResponse.<IntrospectReponse>builder()
                .result(result)
                .build();
    }
}
