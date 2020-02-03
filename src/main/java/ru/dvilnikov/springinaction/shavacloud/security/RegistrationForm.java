package ru.dvilnikov.springinaction.shavacloud.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.dvilnikov.springinaction.shavacloud.User;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname, street, city, phone);
    }
}
