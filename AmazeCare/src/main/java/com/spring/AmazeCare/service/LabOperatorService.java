package com.spring.AmazeCare.service;

import com.spring.AmazeCare.model.LabOperator;
import com.spring.AmazeCare.repository.LabOperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabOperatorService {
    @Autowired
    private LabOperatorRepository labOperatorRepository;

    public List<LabOperator> getAllLabOperators() {
        return labOperatorRepository.findAll();
    }

    public LabOperator saveLabOperator(LabOperator labOperator) {
        return labOperatorRepository.save(labOperator);
    }
}
