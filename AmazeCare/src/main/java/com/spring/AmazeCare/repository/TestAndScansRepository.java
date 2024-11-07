package com.spring.AmazeCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.AmazeCare.model.TestAndScans;

@Repository
public interface TestAndScansRepository extends JpaRepository<TestAndScans, Long> {
}

