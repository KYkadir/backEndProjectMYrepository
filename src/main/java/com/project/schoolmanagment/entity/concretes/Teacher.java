package com.project.schoolmanagment.entity.concretes;

import com.project.schoolmanagment.entity.abstracts.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true,onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class Teacher extends User {

    @OneToOne(mappedBy = "teacher",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private AdvisorTeacher advisorTeacher;

    @Column(name="isAdvisor")
    private Boolean isAdvisor;

    @Column(unique = true)
    private String email;

    // !!! StudentInfo diye bir klas olmali ogrenci ile ilgili bilgileri direk alabilmek icin
    //     Lesson program diye bir klass olmali ve iliski kurulmali

    @OneToMany(mappedBy = "teacher",cascade=CascadeType.REMOVE)
    private List<StudentInfo>studentInfos;

    @ManyToMany
    @JoinTable(
            name="teacher_lessonprogram",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_program_id")
    )
    private Set<LessonProgram> lessonsProgramList;



}
