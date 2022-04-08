package com.example.demo4.persistances.dto.user;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Size(min = 3, max = 25, message = "First name must be between 3 - 25")
    @NotBlank(message = "First Name must not be empty")
    @NotNull
    private String firstName;

    @Size(min = 3, max = 25, message = "Last name must be between 3 - 25")
    @NotNull
    @NotBlank(message = "Last Name must not be empty")
    @Size(min = 2,max = 25,message = "Please add your last name")
    private String lastName;

    @Size(min = 3, max = 25, message = "username must be between 3 - 25")
    @NotNull
    @NotBlank(message = "Username must not be empty")
    @Size(min = 5,max = 25,message = "Please add an acceptable username for security reasons")
    private String username;

    @Size(min = 3, max = 25, message = "Email be between 3 - 25")
    @Email
    @NotNull
    @NotBlank(message = "Email must not be empty")
    private String email;

    @Size(min = 3, max = 800, message = "Comment must be between 3 - 800")
    @NotNull
    @Size(max = 800,message = "You have reach the limit of more that 800 characters")
    private String comment;

    @Size(min = 3, max = 25, message = "Phone must be between 3 - 25")
    @NotNull
    @NotBlank(message = "Phone must not be empty")
    @Pattern(regexp = "(\\+)[0-9]{14}",message = "please enter a valid phone number")
    private String phone;

    @Size(min = 3, max = 100, message = "Address1 name must be between 3 - 100")
    @NotNull
    @NotBlank(message = "Address1 must not be empty")
    private String address1;

    @Size(min = 3, max = 25, message = "Address2 must be between 3 - 100")
    @NotNull
    private String address2;

    @Size(min = 3, max = 100, message = "Address3 name must be between 3 - 100")
    @NotNull
    private String address3;

    private Set<Long> languages;
}
