package com.example.homeworkplatform.registration.repository;

import com.example.homeworkplatform.registration.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public RegisterUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO Users (first_name, last_name, username, email, password_hash, role, phone_number, address, subject, is_class_teacher, qualification, created_at, class_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPasswordHash(),
                user.getRole(), user.getPhoneNumber(), user.getAddress(), user.getSubject(),
                user.getIsClassTeacher(), user.getQualification(), user.getClassName());
    }

    public boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM Users WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }
}
