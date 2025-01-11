package com.example.NguyenVanHuyTest.dto.request;

import com.example.NguyenVanHuyTest.entity.StudentScore;
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
    private Integer id;
    private String studentId;
    private String fullName;
    private String address;
    private List<StudentScoreRequest> scores;
}
