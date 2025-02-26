package com.example.homeworkplatform.reports.services;

import com.example.homeworkplatform.reports.models.Report;

import java.util.List;

public interface ReportService {
    Report getReportById(int id);
    List<Report> getReportsByAuthor(int authorId);
    void generateReport(Report report);
    List<Report> getAllReports();
}