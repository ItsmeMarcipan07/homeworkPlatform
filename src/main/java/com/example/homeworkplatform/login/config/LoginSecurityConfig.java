package com.example.homeworkplatform.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class LoginSecurityConfig {
    @Bean
    public static BCryptPasswordEncoder BCpasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



