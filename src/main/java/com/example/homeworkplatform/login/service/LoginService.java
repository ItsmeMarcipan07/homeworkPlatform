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
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPasswordHash())) {
            return Optional.of(convertToDTO(userOpt.get()));
        }
        return Optional.empty();
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
}

