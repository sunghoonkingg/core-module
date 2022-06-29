package com.example.basiccrud.api;

import com.example.basiccrud.domain.Professor;
import com.example.basiccrud.dto.ProfessorRequestDto;
import com.example.basiccrud.dto.responseDto.ProfessorResponseDto;
import com.example.basiccrud.repository.ProfessorRepository;
import com.example.basiccrud.repository.SubjectRepository;
import com.example.basiccrud.service.ProfessorService;
import com.example.basiccrud.utills.PagingResult;
import com.example.basiccrud.utills.Wrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    // 교수 저장
    @PostMapping("/professors")
    public void createProfessor(@RequestBody ProfessorRequestDto professorDto){
        professorService.setProfessor(professorDto);
    }

    // 교수 목록 조회
    @GetMapping("/professors/{curPage}")
    public PagingResult readProfessor(@PathVariable Integer curPage){
        return professorService.getProfessor(curPage);
    }

    // 교수 조회 전체
    @RequestMapping(value = "/professors",method=RequestMethod.GET)
    public List<ProfessorResponseDto> readSubjects(){
        return professorService.getPro();
    }

    @GetMapping("/professor/{id}")
    public Professor oneProfessor(@PathVariable Long id){
        return professorService.oneProfessor(id);
    }


    // 교수 목록 변경
    @PutMapping("/professors/{id}")
    public String updateProfessor(@PathVariable Long id, @RequestBody ProfessorRequestDto professorRequestDto){
        return professorService.updateProfessor(id, professorRequestDto);
    }

    // 교수 목록 삭제
    @DeleteMapping("/professors")
    public void deleteProfessor(@RequestBody Wrapper professor){
        professorService.deleteProfessor(professor);

    }


}
