package com.skypro.Nplus1.repository;

import com.skypro.Nplus1.model.Comment;
import com.skypro.Nplus1.projections.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT id AS id, body as body, post_id AS postId FROM comment WHERE post_id IN (?1) ", nativeQuery = true)
    List<CommentProjection> findByPostIdIn(List<Long> postIds);


}