package com.skypro.Nplus1.repository;

import com.skypro.Nplus1.model.Post;
import com.skypro.Nplus1.projections.PostProjection;
import com.skypro.Nplus1.projections.TopUsersProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    @Query(value =
            "SELECT u.id as id, u.name as name, COUNT(c.body) AS comments, COUNT(DISTINCT p.id) AS posts,\n" +
            "       (SELECT p.title FROM post p\n" +
            "           JOIN comment c ON p.id = c.post_id\n" +
            "                       GROUP BY p.id, p.title\n" +
            "                       ORDER BY COUNT(c.body)\n" +
            "                       DESC LIMIT 1) AS topPost\n" +
            "FROM users u\n" +
            "    JOIN comment c ON c.user_id = u.id\n" +
            "    JOIN post p ON p.id = c.post_id\n" +
            "GROUP BY u.name, u.id\n" +
            "ORDER BY comments\n" +
            "DESC LIMIT 10;",
            nativeQuery = true)
    List<TopUsersProjection> findTopUsers();

    @EntityGraph(attributePaths = {"comments", "user"})
    List<Post> getAllBy();

    List<PostProjection> findAllBy(Pageable pageable);


}
