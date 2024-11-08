package com.spring.AmazeCare.controller;

import com.spring.AmazeCare.model.LabOperator;
import com.spring.AmazeCare.service.LabOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labOperators")
public class LabOperatorController {
    @Autowired
    private LabOperatorService labOperatorService;

    @GetMapping
    public List<LabOperator> getAllLabOperators() {
        return labOperatorService.getAllLabOperators();
    }

    @PostMapping
    public LabOperator saveLabOperator(@RequestBody LabOperator labOperator) {
        return labOperatorService.saveLabOperator(labOperator);
    }
}
