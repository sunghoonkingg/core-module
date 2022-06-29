package com.example.basiccrud.dto;


import com.example.basiccrud.domain.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {


    private String studentName;
    private int studentAge;
    private String studentAddress;
    private String subjectName;
    private String professorName;

    public StudentRequestDto(String studentName, int studentAge, String studentAddress, String subjectName, String professorName) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentAddress = studentAddress;
        this.subjectName = subjectName;
        this.professorName = professorName;
    }

//    public StudentRequestDto(Professor professor, String subjectName){
//        this.subjectName = professor.getSubject().getSubjectName();
//    }

//    public StudentRequestDto(Student student ,String subjectName){
//
//        this.subjectName = student.getSubject().getSubjectName();
//    }

}

