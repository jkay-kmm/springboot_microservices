package com.anhtrung.learn_spring.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // tạo builder class
@FieldDefaults(level = AccessLevel.PRIVATE) // co the bo private ơ cac bien
public class UserCreationRequest {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 50, message = "USERNAME_INVALID")
     String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
     String password;
     String lastname;
     String firstname;
     LocalDate birthday;



}
