package com.example.NguyenVanHuyTest.dto.request;

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
public class StudentScoreRequest {
    private Long id;
    private Integer studentId;
    private Integer subjectId;
    private Double score1;
    private Double score2;

    public String getGrade() {
        double totalScore = 0.3 * score1 + 0.7 * score2;
        if (totalScore >= 8.0) return "A";
        else if (totalScore >= 6.0) return "B";
        else if (totalScore >= 4.0) return "D";
        else return "F";
    }
}
