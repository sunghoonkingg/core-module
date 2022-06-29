package com.example.basiccrud.repository;


import com.example.basiccrud.domain.Board;
import com.example.basiccrud.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoardOrderByCreatedAtDesc(Board board);

}
