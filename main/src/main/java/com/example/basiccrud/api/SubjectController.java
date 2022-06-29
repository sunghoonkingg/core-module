package com.example.basiccrud.api;

import com.example.basiccrud.domain.Subject;
import com.example.basiccrud.dto.SubjectRequestDto;
import com.example.basiccrud.repository.SubjectRepository;
import com.example.basiccrud.service.SubjectService;

import com.example.basiccrud.utills.PagingResult;
import com.example.basiccrud.utills.Wrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectRepository subjectRepository;



    //과목 저장
    @PostMapping("/subjects")
    public void createSubject(@RequestBody SubjectRequestDto subjectRequestDto)  {
        System.out.println(subjectRequestDto.toString());
        subjectService.setSubject(subjectRequestDto);
    }

    //과목 조회 페이징
    @GetMapping("/subjects/{curPage}")
    public PagingResult readSubject(@PathVariable Integer curPage){
        return subjectService.getSubject(curPage);
    }


    //과목 조회 개별
    @GetMapping("/subject/{id}")
    public Subject oneSubject(@PathVariable Long id){
        return subjectService.oneSubject(id);
    }


    //과목 조회 전체
    @RequestMapping(value = "/subjects",method=RequestMethod.GET)
    public List<Subject> readSubjects(){
        return subjectRepository.findAll();
    }


//    @GetMapping("/subjects/{id}")
//    public Subject getSubject(@PathVariable Long idx) {
//        return subjectService.getSubject(idx);
//    }

    //과목 변경
    @PutMapping("/subjects/{id}")
    public String updateSubject(@PathVariable Long id,@RequestBody SubjectRequestDto subjectRequestDto){
        return subjectService.updateSubject(id,subjectRequestDto);
    }

//    //과목 삭제
//    @GetMapping("/subjectss")
//
//    public void deleteSubject(@RequestParam List<Integer> subjects){
////        System.out.println(subjects);
////        subjectService.deleteSubject(subjects);
//
//        for (Integer subject : subjects) {
//            System.out.println(subject);
//        }
//    }

    //과목 삭제
    @GetMapping("/subjectss")
    public void deleteSubject(@RequestParam(value="quarter")List<Integer> arr) {
//        System.out.println(subjects);
//        subjectService.deleteSubject(subjects);

        for (Integer integer : arr) {
            System.out.println(integer);

        }

    }
}