package com.example.basiccrud.dto.responseDto;


import com.example.basiccrud.domain.Board;
import com.example.basiccrud.domain.Comment;
import com.example.basiccrud.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class CommentResponseDto {
    private Long boardId;
    private String boardUsername;
    private String boardTitle;
    private String boardContent;
    private String boardCreateAt;
    private String boardModifiedAt;


    private Long contentId;
    private String contentUsername;
    private String content;
    private String contentCreatedAt;
    private String contentModifiedAt;

    public CommentResponseDto(Comment comment, Board board, User user) {
        this.boardId = board.getBoardId();
        this.boardTitle = comment.getBoard().getTitle();
        this.boardContent = comment.getBoard().getContent();
        this.boardUsername = comment.getBoard().getUser().getUsername();
        this.boardCreateAt = comment.getBoard().getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.boardModifiedAt = comment.getBoard().getModifiedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        this.contentId = comment.getId();
        this.content = comment.getContent();
        this.contentUsername = user.getUsername();
        this.contentCreatedAt = comment.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.contentModifiedAt = comment.getModifiedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
