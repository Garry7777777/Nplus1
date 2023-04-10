package com.skypro.Nplus1.dto;


import com.skypro.Nplus1.model.Users;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class UserDTO {

    private Long id;
    private String name;

    public static UserDTO fromUser(Users user){
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
     return dto;
    }
}
