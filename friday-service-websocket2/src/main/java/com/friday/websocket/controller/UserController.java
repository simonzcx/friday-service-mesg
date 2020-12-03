package com.friday.websocket.controller;

import com.friday.websocket.model.User;
import com.friday.websocket.util.WsParamName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Simon.z
 * @since: 2020-11-30
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    String userLogin(HttpServletRequest request, User user, Model model) {
        model.addAttribute("name", user.getName());
        model.addAttribute("password", user.getPassword());
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        session.setAttribute(WsParamName.PARAM_TYPE_OF_USER_KEY, user.getName());
        return "websocket";
    }
}
