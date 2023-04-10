package com.skypro.Nplus1.dto;

import com.skypro.Nplus1.model.Post;
import com.skypro.Nplus1.projections.PostProjection;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDTO {

  private Long id;
  private String title;
  private String body;
  private List<CommentDTO> comment;
  private UserDTO user;

  public static PostDTO fromPost(Post post) {
    PostDTO dto = new PostDTO();
    dto.setId(post.getId());
    dto.setTitle(post.getTitle());
    dto.setBody(post.getBody());
    dto.setComment(post.getComments().stream()
            .map(CommentDTO::fromComment)
            .collect(Collectors.toList()));
    dto.setUser(UserDTO.fromUser(post.getUser()));
    return dto;
  }
  public static PostDTO fromPostProj(PostProjection postProjection) {
    PostDTO dto = new PostDTO();
    dto.setId(postProjection.getId());
    dto.setTitle(postProjection.getTitle());
    dto.setBody(postProjection.getBody());
    return dto;
  }
}
