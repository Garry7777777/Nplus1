package com.skypro.Nplus1.service;

import com.skypro.Nplus1.dto.*;
import com.skypro.Nplus1.projections.*;
import com.skypro.Nplus1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.JoinType;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<TopUsersDTO> getTopUsers() {
        return postRepository.findTopUsers().stream()
                .map(TopUsersDTO::fromTopUsersProj).collect(Collectors.toList());
    }

    public List<PostDTO> getAllPosts(){
        return postRepository.getAllBy().stream()
                .map(PostDTO::fromPost)
                .collect(Collectors.toList());
    }

    public List<PostDTO> getAllPostsPages(Pageable pageable) {
        List<PostProjection> postList = postRepository.findAllBy(pageable);
        List<CommentProjection> commentList = commentRepository.findByPostIdIn(postList
                .stream().map(PostProjection::getId).collect(Collectors.toList()));
        return postList.stream().map(PostDTO::fromPostProj)
                .peek(postDTO -> postDTO.setComment(commentList.stream()
                        .filter(comment -> comment.getId().equals(postDTO.getId()))
                        .map(CommentDTO::fromCommentProj)
                        .collect(Collectors.toList()))
                ).collect(Collectors.toList());
    }

    public List<PostDTO> getPostLike(String body) {
        return postRepository.findAll((root, query, criteriaBuilder) -> {
            root.fetch("comments", JoinType.LEFT)
                    .fetch("user", JoinType.LEFT);
            query.distinct(true);
            return criteriaBuilder.like(root.join("comments").get("body"), "%" + body + "%");})
                .stream().map(PostDTO::fromPost).collect(Collectors.toList());
    }


}