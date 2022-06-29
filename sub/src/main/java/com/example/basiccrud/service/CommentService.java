package com.example.basiccrud.service;


import com.example.basiccrud.domain.Board;
import com.example.basiccrud.domain.Comment;
import com.example.basiccrud.domain.User;
import com.example.basiccrud.dto.BoardCommentRequestDto;
import com.example.basiccrud.dto.CommentRequestDto;
import com.example.basiccrud.dto.responseDto.CommentResponseDto;
import com.example.basiccrud.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 저장
    public void setArticleComment(CommentRequestDto commentRequestDto, User user) {

        Board board = new Board(commentRequestDto.getBoardId());
        Comment comment = new Comment(commentRequestDto, board, user);

        commentRepository.save(comment);
    }

    // 댓글 조회
    public List<CommentResponseDto> getComments(Long id) {
        List<CommentResponseDto> commentResponseDtoList = new LinkedList<>();
        Board board = new Board(id);
        List<Comment> commentList = commentRepository.findByBoardOrderByCreatedAtDesc(board);
        for (Comment comment : commentList) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment, board,comment.getUser());
            commentResponseDtoList.add(commentResponseDto);
        }

        return commentResponseDtoList;
    }

    //댓글 업데이트
    @Transactional
    public String updateComment(BoardCommentRequestDto boardCommentRequestDto, User user) {
        Comment comment = commentRepository.findById(boardCommentRequestDto.getCommentId()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지않습니다.")
        );
        if(user.getUsername().equals(comment.getUser().getUsername())){
            comment.setContent(boardCommentRequestDto.getContent());
            return "success";
        }
        else{
            return "fail";
        }
    }


    // 댓글 삭제
    @Transactional
    public String deleteComment(Long commentId, User user){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지않습니다.")
        );
        if(user.getUsername().equals(comment.getUser().getUsername())){
            commentRepository.deleteById(commentId);
            return "success";
        }
        else{
            return "fail";
        }

    }



}
