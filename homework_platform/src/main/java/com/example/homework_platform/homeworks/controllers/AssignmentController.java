package com.example.homework_platform.homeworks.controllers;

import com.example.homework_platform.homeworks.models.Assignment;
import com.example.homework_platform.homeworks.services.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createAssignment(@RequestBody Assignment assignment) {
        service.createAssignment(assignment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAssignment(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAssignment(@PathVariable Long id, @RequestBody Assignment updatedAssignment) {
        service.updateAssignment(id, updatedAssignment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        service.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}

