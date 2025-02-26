package com.example.homeworkplatform.grades.services;

import com.example.homeworkplatform.grades.models.Grade;

public interface GradeService {
    Grade getGradeById(int id);
    Grade getGradeByStudentAndAssignment(int studentId, int assignmentId);
    void updateGrade(Grade grade);
}