package com.anhtrung.learn_spring.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
     String username;
     String lastname;
     String firstname;
     LocalDate birthday;
     Set<String> roles;
}
