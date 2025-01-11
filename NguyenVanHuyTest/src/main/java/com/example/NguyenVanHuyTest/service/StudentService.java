package com.example.NguyenVanHuyTest.service;

import com.example.NguyenVanHuyTest.dto.request.StudentRequest;
import com.example.NguyenVanHuyTest.dto.request.StudentScoreRequest;
import com.example.NguyenVanHuyTest.dto.response.StudentResponse;
import com.example.NguyenVanHuyTest.entity.Student;
import com.example.NguyenVanHuyTest.entity.StudentScore;
import com.example.NguyenVanHuyTest.entity.Subject;
import com.example.NguyenVanHuyTest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentScoreService studentScoreService;

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            for (StudentScore score: student.getScores()) {
                StudentResponse studentResponse = new StudentResponse();
                Subject subject = score.getSubject();
                studentResponse.setStudentId(student.getStudentCode());
                studentResponse.setFullName(student.getFullName());
                studentResponse.setSubjectName(subject.getSubjectName());
                studentResponse.setScore1(score.getScore1());
                studentResponse.setScore2(score.getScore2());
                studentResponse.setCredit(subject.getCredit());
                studentResponse.setGrade(score.getGrade());
                studentResponses.add(studentResponse);
            }
        }
        return studentResponses;
    }

    public Student saveStudent(StudentRequest request) {
        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setStudentCode(request.getStudentCode());
        student.setAddress(request.getAddress());
        Student savedStudent = studentRepository.save(student);
        List<StudentScoreRequest> scores = request.getScores();
        for (StudentScoreRequest score : scores) {
            studentScoreService.saveStudentScore(score);
        }
        return savedStudent;
    }

    public Student updateStudent(StudentRequest request) {
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        student.setFullName(request.getFullName());
        student.setStudentCode(request.getStudentCode());
        student.setAddress(request.getAddress());
        Student savedStudent = studentRepository.save(student);
        List<StudentScoreRequest> scores = request.getScores();
        for (StudentScoreRequest score : scores) {
            studentScoreService.saveStudentScore(score);
        }
        return savedStudent;
    }
}

