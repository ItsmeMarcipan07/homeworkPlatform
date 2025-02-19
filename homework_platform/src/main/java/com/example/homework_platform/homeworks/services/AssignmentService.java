package com.example.homework_platform.homeworks.services;

import com.example.homework_platform.homeworks.models.Assignment;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    private final AssignmentRepository repository;

    public AssignmentService(AssignmentRepository repository) {
        this.repository = repository;
    }

    public void createAssignment(Assignment assignment) {
        repository.save(assignment);
    }

    public Assignment getAssignment(Long id) {
        return repository.findById(id);
    }

    public void updateAssignment(Long id, Assignment updatedAssignment) {
        repository.update(id, updatedAssignment);
    }

    public void deleteAssignment(Long id) {
        repository.delete(id);
    }
}