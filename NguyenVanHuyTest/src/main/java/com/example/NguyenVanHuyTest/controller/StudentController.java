package com.example.NguyenVanHuyTest.controller;

import com.example.NguyenVanHuyTest.dto.request.StudentRequest;
import com.example.NguyenVanHuyTest.dto.response.StudentResponse;
import com.example.NguyenVanHuyTest.entity.Student;
import com.example.NguyenVanHuyTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponse> getStudentInformation() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRequest student) {
        return studentService.saveStudent(student);
    }

    @PostMapping
    public Student updateStudent(@RequestBody StudentRequest student) {
        return studentService.updateStudent(student);
    }
}

