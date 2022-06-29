package com.example.basiccrud.dto.responseDto;


import com.example.basiccrud.domain.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StudentResponseDto {

    private Long id;
    private String studentName;
    private int studentAge;
    private String studentAddress;
    private String professorName;
    private String subjectName;

    public StudentResponseDto(Student student){
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentAge = student.getStudentAge();
        this.studentAddress = student.getStudentAddress();
        this.professorName = student.getProfessor().getProfessorName();
        this.subjectName = student.getSubject().getSubjectName();
    }
}
