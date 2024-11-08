package com.spring.AmazeCare.service;

import com.spring.AmazeCare.model.TestAndScans;
import com.spring.AmazeCare.repository.TestAndScansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestAndScansService {
    @Autowired
    private TestAndScansRepository testAndScansRepository;

    public List<TestAndScans> getAllTestAndScans() {
        return testAndScansRepository.findAll();
    }

    public TestAndScans createTestAndScans(TestAndScans testAndScans) {
        return testAndScansRepository.save(testAndScans);
    }

    public TestAndScans updateTestAndScans(Long id, TestAndScans testAndScans) {
        testAndScans.setId(id);
        return testAndScansRepository.save(testAndScans);
    }
}
