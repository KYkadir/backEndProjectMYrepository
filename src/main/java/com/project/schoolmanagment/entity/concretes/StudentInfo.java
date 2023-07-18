package com.project.schoolmanagment.entity.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.schoolmanagment.entity.enums.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer absentee;
    private Double midtermExam;
    private Double finalExam;
    private Double examAverage;

    private String infoNote;

    @ManyToOne

    private Teacher teacher;
    @JsonIgnoreProperties("teacher")
    @ManyToOne
    private Student student;

    @Enumerated(EnumType.STRING)
    private Note letterGrade;

    // !!! Lesson tablosu kurulduktan sonra iliski kurulmali
    //     EducationTerm ile guz donemi yaz donemi iliskileri kurulmali

    @ManyToOne
    @JsonIgnoreProperties("lesson")
    private Lesson lesson;

    @OneToOne
    private EducationTerm educationTerm;



}
