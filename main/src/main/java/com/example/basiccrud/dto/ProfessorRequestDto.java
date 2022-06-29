package com.example.basiccrud.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProfessorRequestDto {

    private String professorName;
    private int professorAge;
    private String subjectName;

    public ProfessorRequestDto(String professorName, int professorAge, String subjectName) {
        this.professorName = professorName;
        this.professorAge = professorAge;
        this.subjectName = subjectName;
    }
}
