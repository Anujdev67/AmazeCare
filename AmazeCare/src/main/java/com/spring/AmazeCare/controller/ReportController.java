package com.spring.AmazeCare.controller;

import com.spring.AmazeCare.model.Report;
import com.spring.AmazeCare.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id, @RequestBody Report report) {
        return reportService.updateReport(id, report);
    }
}
