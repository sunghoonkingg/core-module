package com.example.basiccrud.api;


import com.example.basiccrud.domain.Board;
import com.example.basiccrud.domain.User;
import com.example.basiccrud.dto.BoardRequestDto;
import com.example.basiccrud.security.UserDetailsImpl;
import com.example.basiccrud.service.BoardService;
import com.example.basiccrud.utills.PagingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardController {


    private final BoardService boardService;


    //게시판 글 생성
    @PostMapping("/boards")
    public String createBoard(@RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        boardService.setBoard(boardRequestDto, user);
        return "ok";

    }
    //게시한 글 조회
    @GetMapping("/boards/{curPage}")
    public PagingResult readBoard(@PathVariable Integer curPage) {
        return boardService.getBoards(curPage);
    }

    // 게시판 글 상세조회
    @GetMapping("/board/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    // 게시판 글 수정
    @PutMapping("/boards/{id}")
    public String updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return boardService.updateBoard(id,boardRequestDto, user);
    }


    // 게시판 글 삭제
    @DeleteMapping("/boards/{id}")
    public String deleteBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return boardService.deleteById(id, user);
    }


}
