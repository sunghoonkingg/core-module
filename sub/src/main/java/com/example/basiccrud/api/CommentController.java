package com.example.basiccrud.api;


import com.example.basiccrud.domain.User;
import com.example.basiccrud.dto.BoardCommentRequestDto;
import com.example.basiccrud.dto.CommentRequestDto;
import com.example.basiccrud.dto.responseDto.CommentResponseDto;
import com.example.basiccrud.security.UserDetailsImpl;
import com.example.basiccrud.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;
    private UserDetailsImpl userDetails;


    //댓글 작성
    @PostMapping("/comments")
    public String setComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        commentService.setArticleComment(commentRequestDto, user);
        return "ok";
    }

    //댓글
    @GetMapping("/comments/{id}")
    public List<CommentResponseDto> getBoardComment(@PathVariable Long id) {
        return commentService.getComments(id);

    }

    //댓글 수정
    @PutMapping("/comments")
    public String updateComment(@RequestBody BoardCommentRequestDto boardCommentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return commentService.updateComment(boardCommentRequestDto, user);
    }

    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return commentService.deleteComment(commentId, user);
    }


}
