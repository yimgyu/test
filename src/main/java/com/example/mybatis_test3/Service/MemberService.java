package com.example.mybatis_test3.Service;

import com.example.mybatis_test3.DTO.UserDTO;
import com.example.mybatis_test3.Entity.User_info_Entity;
import com.example.mybatis_test3.Repository.User_join_Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final User_join_Mapper user_join_mapper;

    public int save(UserDTO udto){
        User_info_Entity ui_entity = User_info_Entity.touser_info_Entity(udto);

        return user_join_mapper.insert_User(ui_entity);
    }


    public int id_check(String user_id){

        return user_join_mapper.id_check(user_id);
    }

    public UserDTO login(String user_id, String user_pw){
        User_info_Entity user_info_entity = new User_info_Entity();
        user_info_entity.setUser_id(user_id);
        user_info_entity.setUser_pw(user_pw);

        return user_join_mapper.login(user_info_entity);
    }

    public int uuid_check(String uuid){

        return user_join_mapper.uuid_check(uuid);
    }

}

