package com.skypro.Nplus1.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String body;
  @ManyToOne
  private Users user;
  @ManyToOne
  private Post post;

}
