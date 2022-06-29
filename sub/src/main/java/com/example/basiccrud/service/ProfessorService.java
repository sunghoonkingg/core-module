package com.example.basiccrud.service;

import com.example.basiccrud.domain.Professor;
import com.example.basiccrud.domain.Subject;
import com.example.basiccrud.dto.ProfessorRequestDto;
import com.example.basiccrud.dto.responseDto.ProfessorResponseDto;
import com.example.basiccrud.repository.ProfessorRepository;
import com.example.basiccrud.repository.SubjectRepository;
import com.example.basiccrud.utills.PagingResult;
import com.example.basiccrud.utills.Wrapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private static final Logger log = LoggerFactory.getLogger(ProfessorService.class.getName());
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private static final int BLOCK_PAGE_NUM_COUNT = 8;

    //교수 목록 만들기
    @Transactional
    public Professor setProfessor(ProfessorRequestDto professorRequestDto) {
        Subject sub = subjectRepository.findBySubjectName(professorRequestDto.getSubjectName()).orElseThrow(
                () -> new NullPointerException("해당 과목이 없습니다")
        );
        Professor professor = new Professor(professorRequestDto, sub);
        professorRepository.save(professor);
        return professor;
    }


    //교수 목록 조회 페이징
    public PagingResult getProfessor(int curPage) {
        List<ProfessorResponseDto> professorResponseDtoList = new LinkedList<>();
        Pageable pageable = PageRequest.of(curPage - 1, BLOCK_PAGE_NUM_COUNT);
        Page<Professor> professors = professorRepository.findAllByOrderByCreatedAtDesc(pageable);
        List<Professor> professorList = professors.getContent();
        for(Professor professor : professorList){
            ProfessorResponseDto professorResponseDto = new ProfessorResponseDto(professor);
            professorResponseDtoList.add(professorResponseDto);
        }
//        }



        return new PagingResult(professorResponseDtoList, professors.getTotalPages());
    }

    // 교수 목록 변경
    @Transactional
    public String updateProfessor(Long id, ProfessorRequestDto professorRequestDto) {
        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이다가 존재하지 않습니다")
        );
        professor.update(professorRequestDto);
        return "success";
    }

    // 교수 목록 선택택삭제
    @Transactional
    public void deleteProfessor(Wrapper professors) {

        List<String> test = professors.getProfessors();

        for (String s : test
        ) {
            long id = Long.parseLong(s);

            professorRepository.deleteById(id);

        }
    }

    // 교수 전체조회
    public List<ProfessorResponseDto> getPro() {
        List<ProfessorResponseDto> professorResponseDtoList = new LinkedList<>();
//        List<Professor> professorList = professors.getContent();
//
//        for (Professor s : datas) {
//            System.out.println(s);
//            System.out.println(s.getSubject().getSubjectName());
//        }
        return professorRepository.findAll()
                .stream()
                .map(n -> new ProfessorResponseDto(n.getId(),n.getProfessorName(), n.getProfessorAge(), n.getSubject().getSubjectName()))
                .collect(Collectors.toList());


    }


    public Professor oneProfessor(Long id) {
        return professorRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
    }
}
