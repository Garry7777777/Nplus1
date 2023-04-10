package com.skypro.Nplus1.dto;

import com.skypro.Nplus1.model.Comment;
import com.skypro.Nplus1.projections.CommentProjection;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CommentDTO {

    private Long id;
    private String body;

    public static CommentDTO fromComment(Comment comment) {
        CommentDTO dto = new CommentDTO();
        BeanUtils.copyProperties(comment, dto);
        return dto;
    }
    public static CommentDTO fromCommentProj(CommentProjection commentProjection) {
        CommentDTO dto = new CommentDTO();
        BeanUtils.copyProperties(commentProjection, dto);
        return dto;
    }

}
