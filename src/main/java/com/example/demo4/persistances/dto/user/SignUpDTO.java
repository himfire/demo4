package com.example.demo4.persistances.dto.user;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    @Size(min = 3, max = 25, message = "First name must be between 3 - 25")
    @NotBlank(message = "First Name must not be empty")
    @NotNull
    private String firstName;

    @Size(min = 3, max = 25, message = "Last name must be between 3 - 25")
    @NotNull
    @NotBlank(message = "Last Name must not be empty")
    private String lastName;


    @Size(min = 3, max = 25, message = "username must be between 3 - 25")
    @NotNull
    @NotBlank(message = "Username must not be empty")
    private String username;

    @Size(min = 3, max = 25, message = "Email be between 3 - 25")
    @Email
    @NotNull
    @NotBlank(message = "Email must not be empty")
    private String email;

    @NotNull
    @NotBlank(message = "Password must not be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Size(min = 3, max = 25, message = "Phone must be between 3 - 25")
    @NotNull
    @NotBlank(message = "Phone must not be empty")
    private String phone;
}
