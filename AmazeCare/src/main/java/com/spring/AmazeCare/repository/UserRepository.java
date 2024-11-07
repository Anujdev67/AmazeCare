package com.spring.AmazeCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.AmazeCare.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}