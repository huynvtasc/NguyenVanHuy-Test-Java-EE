package com.example.NguyenVanHuyTest.repository;

import com.example.NguyenVanHuyTest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

