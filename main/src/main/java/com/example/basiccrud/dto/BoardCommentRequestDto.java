package com.example.basiccrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCommentRequestDto {

    private Long boardId;
    private Long commentId;
    private String content;
}
