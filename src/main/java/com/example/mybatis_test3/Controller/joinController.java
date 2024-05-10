package com.example.mybatis_test3.Controller;

import com.example.mybatis_test3.DTO.UserDTO;
import com.example.mybatis_test3.Service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class joinController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String saveForm(){
        return "join";
    }

    @PostMapping("/join")
    public String save(@RequestParam("join_id") String join_id,
                       @RequestParam("join_pw") String join_pw,
                       @RequestParam("join_name") String join_name,
                       Model model){

        String user_name_uuid = UUID.randomUUID().toString();

        user_name_uuid = user_name_uuid.replaceAll("-","");

        user_name_uuid = user_name_uuid.substring(0,16);

        user_name_uuid = user_name_uuid.replaceAll("(.{4})(.{4})(.{4})(.{4})", "$1-$2-$3-$4");

        int check_uuid = memberService.uuid_check(user_name_uuid);

        while(check_uuid == 1) {
            check_uuid = memberService.uuid_check(user_name_uuid);
        }

        UserDTO udto = new UserDTO();

        udto.setUser_id(join_id);
        udto.setUser_pw(join_pw);
        udto.setUser_name(join_name);
        udto.setUser_name_uuid(user_name_uuid);

        int join_check = memberService.save(udto);
        model.addAttribute("join_check", join_check);
        return "home";
    }

    @GetMapping("/id_check")
    @ResponseBody
    public int id_check(@RequestParam("user_id") String join_id){
        return memberService.id_check(join_id);
    }

    @PostMapping("/login")
    public String login(@RequestParam("login_id") String user_id,
                        @RequestParam("login_pw") String user_pw,
                        HttpSession session, Model model){

        UserDTO loginResult = memberService.login(user_id, user_pw);

        if(loginResult != null){
            session.setAttribute("user_name", loginResult.getUser_name());
            return "success";
        }
        else{
            model.addAttribute("loginFail",true);
            return "home";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest req, HttpServletResponse res){

        Cookie[] cookies = req.getCookies();
        if (cookies != null) { // 쿠키가 한개라도 있으면 실행
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // 유효시간을 0으로 설정
                res.addCookie(cookie); // 응답에 추가하여 만료시키기.
            }
        }
        session.invalidate();
        return "home";
    }
}
