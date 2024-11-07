package com.spring.AmazeCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.AmazeCare.model.LabOperator;

@Repository
public interface LabOperatorRepository extends JpaRepository<LabOperator, Long> {
}

