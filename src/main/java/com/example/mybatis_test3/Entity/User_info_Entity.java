package com.example.mybatis_test3.Entity;

import com.example.mybatis_test3.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_test2")
public class User_info_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String user_id;

    @Column
    private String user_pw;

    @Column
    private String user_name;

    @Column(unique = true)
    private String user_name_uuid;

    public static User_info_Entity touser_info_Entity(UserDTO udto){
        User_info_Entity us_Entity = new User_info_Entity();
        us_Entity.setId(udto.getId());
        us_Entity.setUser_id(udto.getUser_id());
        us_Entity.setUser_pw(udto.getUser_pw());
        us_Entity.setUser_name(udto.getUser_name());
        us_Entity.setUser_name_uuid(udto.getUser_name_uuid());
        return us_Entity;
    }
}
