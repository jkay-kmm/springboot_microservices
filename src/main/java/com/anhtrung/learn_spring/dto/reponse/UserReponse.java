package com.anhtrung.learn_spring.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserReponse {
    String id;
     String username;
     String password;
     String lastname;
     String firstname;
     LocalDate birthday;
}
