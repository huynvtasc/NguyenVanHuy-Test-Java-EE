package com.example.NguyenVanHuyTest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private String studentId;
    private String fullName;
    private String subjectName;
    private Double score1;
    private Double score2;
    private Integer credit;
    private String grade;
}
