package com.example.basiccrud.domain;


import com.example.basiccrud.dto.ProfessorRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Professor extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "professor_id")
    private Long id;

    @Column(nullable = false)
    private String professorName;

    @Column(nullable = false)
    private int professorAge;

//    @JsonIgnore

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subjectId",nullable = false)
    private Subject subject;





    public Professor(ProfessorRequestDto professorRequestDto, Subject sub){
        this.professorName = professorRequestDto.getProfessorName();
        this.professorAge = professorRequestDto.getProfessorAge();
        this.subject = sub;


    }

    public Professor update(ProfessorRequestDto professorRequestDto){
        this.professorName = professorRequestDto.getProfessorName();
        this.professorAge = professorRequestDto.getProfessorAge();

        return this;
    }


}
