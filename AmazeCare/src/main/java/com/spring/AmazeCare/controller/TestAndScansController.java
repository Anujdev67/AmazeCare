package com.spring.AmazeCare.controller;

import com.spring.AmazeCare.model.TestAndScans;
import com.spring.AmazeCare.service.TestAndScansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testAndScans")
public class TestAndScansController {
    @Autowired
    private TestAndScansService testAndScansService;

    @GetMapping
    public List<TestAndScans> getAllTestAndScans() {
        return testAndScansService.getAllTestAndScans();
    }

    @PostMapping
    public TestAndScans createTestAndScans(@RequestBody TestAndScans testAndScans) {
        return testAndScansService.createTestAndScans(testAndScans);
    }

    @PutMapping("/{id}")
    public TestAndScans updateTestAndScans(@PathVariable Long id, @RequestBody TestAndScans testAndScans) {
        return testAndScansService.updateTestAndScans(id, testAndScans);
    }
}
