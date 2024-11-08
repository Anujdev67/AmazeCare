package com.spring.AmazeCare.repository;

import com.spring.AmazeCare.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
