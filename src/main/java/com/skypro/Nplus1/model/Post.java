package com.skypro.Nplus1.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String body;
  private String title;
  @ManyToOne
  private Users user;
  @Fetch(FetchMode.SUBSELECT)
  @OneToMany(mappedBy = "post")
  private List<Comment> comments ;

}
