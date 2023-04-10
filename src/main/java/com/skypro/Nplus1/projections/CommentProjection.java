package com.skypro.Nplus1.projections;

import com.skypro.Nplus1.dto.CommentDTO;

public interface CommentProjection {

    Long getId();
    String getBody();
    Long getPostId();

    default CommentDTO toCommentDTO () {
        CommentDTO dto = new CommentDTO();
        dto.setId(getId());
        dto.setBody(getBody());
        return dto;
    }

}
