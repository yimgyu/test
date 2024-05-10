package com.example.mybatis_test3.DTO;

import com.example.mybatis_test3.Entity.User_info_Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_name_uuid;

    public static UserDTO toMemberDTO(User_info_Entity ui_entity) {
        UserDTO udto = new UserDTO();
        udto.setId(ui_entity.getId());
        udto.setUser_id(ui_entity.getUser_id());
        udto.setUser_pw(ui_entity.getUser_pw());
        udto.setUser_name(ui_entity.getUser_name());
        udto.setUser_name_uuid(ui_entity.getUser_name_uuid());

        return udto;
    }
}
