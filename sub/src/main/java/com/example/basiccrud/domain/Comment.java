package com.example.basiccrud.domain;


import com.example.basiccrud.dto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Comment extends TimeStamped{

    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
    private Board board;

    @JsonBackReference
    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    public Comment(CommentRequestDto commentRequestDto, Board board, User user) {

        this.content = commentRequestDto.getContent();
        this.board = board;
        this.user = user;

    }
}
