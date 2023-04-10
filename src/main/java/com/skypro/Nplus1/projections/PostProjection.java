package com.skypro.Nplus1.projections;

import com.skypro.Nplus1.dto.PostDTO;

public interface PostProjection {
    Long getId();
    String getTitle();
    String getBody();
}
