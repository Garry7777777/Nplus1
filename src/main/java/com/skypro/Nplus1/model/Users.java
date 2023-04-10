package com.skypro.Nplus1.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Post> posts;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Comment> comments;
}
