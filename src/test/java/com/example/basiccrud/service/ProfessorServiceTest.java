package com.example.basiccrud.service;


import com.example.basiccrud.domain.Professor;
import com.example.basiccrud.domain.Subject;
import com.example.basiccrud.dto.ProfessorRequestDto;
import com.example.basiccrud.dto.SubjectRequestDto;
import com.example.basiccrud.repository.ProfessorRepository;
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
public class ProfessorServiceTest {

    @Mock
    ProfessorRepository professorRepository;

    @Mock
    SubjectRepository subjectRepository;

    ProfessorRequestDto professorRequestDto;

    @InjectMocks
    ProfessorService professorService;

    @Test
    @DisplayName("교수 저장할 때")
    void newProfessor(){

        //given
        Subject subject = new Subject();

        subject.setId(1L);
        subject.setSubjectName("컴퓨터공학과");

        Professor professor = null;


        professorRequestDto = new ProfessorRequestDto("김가브리엘",45,"컴퓨터공학과");


        ArgumentCaptor<Professor> captor = ArgumentCaptor.forClass(Professor.class);

        given(subjectRepository.findBySubjectName("컴퓨터공학과")).willReturn(Optional.ofNullable(subject));
        //when

        Professor result = professorService.setProfessor(professorRequestDto);

        //then
        verify(professorRepository,times(1)).save(captor.capture());
        Professor result1 = captor.getValue();

        assertEquals(result1.getProfessorName(),"김가브리엘");
        assertEquals(result1.getProfessorAge(),45);
        assertEquals(result1.getSubject().getSubjectName(),"컴퓨터공학과");
    }
}
