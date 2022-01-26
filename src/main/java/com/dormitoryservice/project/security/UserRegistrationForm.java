package com.dormitoryservice.project.Security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserRegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String phone;

    User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setFullName(this.fullName);
        user.setPhone(this.phone);
        //user.setUserRole("ROLE_USER");
        return user;
    }
}
