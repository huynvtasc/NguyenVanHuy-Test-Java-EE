package com.example.NguyenVanHuyTest.repository;

import com.example.NguyenVanHuyTest.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
}

