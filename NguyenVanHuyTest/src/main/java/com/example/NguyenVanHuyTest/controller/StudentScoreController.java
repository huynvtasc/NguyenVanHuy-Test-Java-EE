package com.example.NguyenVanHuyTest.controller;

import com.example.NguyenVanHuyTest.dto.request.StudentScoreRequest;
import com.example.NguyenVanHuyTest.entity.StudentScore;
import com.example.NguyenVanHuyTest.service.StudentScoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students-score")
public class StudentScoreController {
    private final StudentScoreService studentScoreService;

    public StudentScoreController(StudentScoreService studentScoreService) {
        this.studentScoreService = studentScoreService;
    }

    @PostMapping
    public StudentScore saveStudentScore(@RequestBody StudentScoreRequest studentScore) {
        return studentScoreService.saveStudentScore(studentScore);
    }
}
