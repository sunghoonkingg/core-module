package com.example.basiccrud.service;


import com.example.basiccrud.domain.Professor;
import com.example.basiccrud.domain.Student;
import com.example.basiccrud.domain.Subject;
import com.example.basiccrud.dto.StudentRequestDto;
import com.example.basiccrud.repository.ProfessorRepository;
import com.example.basiccrud.repository.StudentRepository;
import com.example.basiccrud.repository.SubjectRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.transaction.Transactional;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Transactional
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    SubjectRepository subjectRepository;

    @Mock
    ProfessorRepository professorRepository;

    StudentRequestDto studentRequestDto;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("학생 저장할 때")
    void newStudent(){

        //given
        Subject subject = new Subject();

        subject.setId(1L);
        subject.setSubjectName("컴퓨터공학과");

        Professor professor = new Professor();

        professor.setId(2L);
        professor.setProfessorName("김가브리엘");
        professor.setProfessorAge(45);

        studentRequestDto = new StudentRequestDto("김성훈",24,"수원시","컴퓨터공학과","김가브리엘");

        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);

        given(subjectRepository.findBySubjectName("컴퓨터공학과")).willReturn(Optional.ofNullable(subject));
        given(professorRepository.findByProfessorName("김가브리엘")).willReturn(Optional.ofNullable(professor));

        //when
        Student re = studentService.setStudentInfo(studentRequestDto);

        verify(studentRepository,times(1)).save(captor.capture());
        Student result = captor.getValue();

        //then

        assertEquals(result.getStudentName(),"김성훈");
        assertEquals(result.getStudentAge(),24);
        assertEquals(result.getStudentAddress(),"수원시");
        assertEquals(result.getSubject().getSubjectName(),"컴퓨터공학과");
        assertEquals(result.getProfessor().getProfessorName(),"김가브리엘");




//        studentRequestDto = new StudentRequestDto("")
    }

}
