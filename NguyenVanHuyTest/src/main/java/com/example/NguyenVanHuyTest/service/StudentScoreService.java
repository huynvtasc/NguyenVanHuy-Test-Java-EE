package com.example.NguyenVanHuyTest.service;

import com.example.NguyenVanHuyTest.dto.request.StudentScoreRequest;
import com.example.NguyenVanHuyTest.entity.Student;
import com.example.NguyenVanHuyTest.entity.StudentScore;
import com.example.NguyenVanHuyTest.entity.Subject;
import com.example.NguyenVanHuyTest.repository.StudentRepository;
import com.example.NguyenVanHuyTest.repository.StudentScoreRepository;
import com.example.NguyenVanHuyTest.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreRepository studentScoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;


    public StudentScore saveStudentScore(StudentScoreRequest request) {
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow(
                () -> new RuntimeException("Student not found")
        );

        Subject subject = subjectRepository.findById(request.getSubjectId()).orElseThrow(
                () -> new RuntimeException("Subject not found")
        );

        StudentScore studentScore = new StudentScore();
        studentScore.setStudent(student);
        studentScore.setSubject(subject);
        studentScore.setScore1(request.getScore1());
        studentScore.setScore2(request.getScore2());
        return studentScoreRepository.save(studentScore);
    }
}
