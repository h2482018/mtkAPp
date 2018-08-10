package com.zdu.mtApp.web.controller;

import com.zdu.mtApp.web.view.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        
        boolean verify = username.length() > 8;
        if (session.isNew()) {
            if (verify) {
                session.setAttribute("MY_SESSION", username);
                return "index";
            } else {
                return "login";
            }
        } else {
            return "已经登陆";
        }
        
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("MY_SESSION");
        return "remove";
    }
}
