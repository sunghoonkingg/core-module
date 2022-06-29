package com.example.basiccrud.domain;

import com.example.basiccrud.dto.BoardRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Board extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "board_id")
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore //순환참조 제거
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;


    public Board(BoardRequestDto boardRequestDto, User user) {


        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
//        this.boardId = boardRequestDto.getId();
        this.user = user;
    }
    public Board(Long board) {
        this.boardId = board;
    }

    public Board update(BoardRequestDto requestDto, User user) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = user;
        return this;
    }

}
