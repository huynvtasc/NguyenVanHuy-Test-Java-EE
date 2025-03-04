package com.example.NguyenVanHuyTest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private Integer studentId;
    private String studentCode;
    private String fullName;
    private String address;
    private List<StudentScoreRequest> scores;
}
