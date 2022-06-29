package com.example.basiccrud.dto.responseDto;


import com.example.basiccrud.domain.Professor;
import com.example.basiccrud.domain.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorResponseDto {

    private Long id;
    private String professorName;
    private int professorAge;
    private String subjectName;


    public ProfessorResponseDto(Long id,String professorName, int professorAge, String subjectName){
        this.id = id;
        this.professorName = professorName;
        this.professorAge = professorAge;
        this.subjectName = subjectName;
    }

    public ProfessorResponseDto(Professor professor){
        this.id = professor.getId();
        this.professorName = professor.getProfessorName();
        this.professorAge = professor.getProfessorAge();
        this.subjectName = professor.getSubject().getSubjectName();
    }
}