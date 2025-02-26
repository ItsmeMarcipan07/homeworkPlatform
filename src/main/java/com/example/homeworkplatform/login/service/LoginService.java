package com.example.homeworkplatform.login.service;

import com.example.homeworkplatform.login.dto.UserDTO;
import com.example.homeworkplatform.login.entity.User;
import com.example.homeworkplatform.login.repository.LoginUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginService(LoginUserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserDTO> login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        if ("PENDING".equalsIgnoreCase(user.getStatus())) {
            throw new IllegalStateException("Your account is pending approval.");
        }
        if ("DELETED".equalsIgnoreCase(user.getStatus())) {
            throw new IllegalStateException("Your account has been deleted.");
        }

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        return Optional.of(convertToDTO(user));
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.getStatus());
    }
}