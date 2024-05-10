package com.example.mybatis_test3.Repository;

import com.example.mybatis_test3.DTO.UserDTO;
import com.example.mybatis_test3.Entity.User_info_Entity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface User_join_Mapper {
    int insert_User(User_info_Entity user_info_entity);

    Integer id_check(String user_id);

    UserDTO login(User_info_Entity user_info_entity);

    int uuid_check(String uuid);
}
