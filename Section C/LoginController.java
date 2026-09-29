package com.jatin.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jatin.dao.LoginDAO;

@Controller
public class LoginController {

    @Autowired
    LoginDAO dao;

    @RequestMapping("/login")
    public ModelAndView login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {

        boolean result = dao.validateUser(username, password);

        if (result) {

            session.setAttribute("username", username);

            return new ModelAndView("redirect:/dashboard.jsp");

        } else {

            return new ModelAndView("redirect:/login.jsp");
        }
    }
}