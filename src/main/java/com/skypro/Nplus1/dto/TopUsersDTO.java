package com.skypro.Nplus1.dto;

import com.skypro.Nplus1.model.Users;
import com.skypro.Nplus1.projections.TopUsersProjection;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class TopUsersDTO {
    private Long id;
    private String name;
    private Long countPost;
    private Long countComment;
    private Long post;

    public static TopUsersDTO fromTopUsersProj(TopUsersProjection user){
        TopUsersDTO dto = new TopUsersDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
