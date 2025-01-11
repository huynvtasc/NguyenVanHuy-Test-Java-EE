package com.example.NguyenVanHuyTest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_score_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Integer studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_id"))
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false, foreignKey = @ForeignKey(name = "fk_subject_id"))
    private Subject subject;

    @Column(name = "score1", precision = 5, scale = 2)
    private Double score1;

    @Column(name = "score2", precision = 5, scale = 2)
    private Double score2;

    @Transient
    public String getGrade() {
        double totalScore = 0.3 * score1 + 0.7 * score2;
        if (totalScore >= 8.0) return "A";
        else if (totalScore >= 6.0) return "B";
        else if (totalScore >= 4.0) return "D";
        else return "F";
    }
}
