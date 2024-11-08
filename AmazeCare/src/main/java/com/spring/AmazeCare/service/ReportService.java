package com.spring.AmazeCare.service;

import com.spring.AmazeCare.model.Report;
import com.spring.AmazeCare.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report report) {
        report.setId(id);
        return reportRepository.save(report);
    }
}
