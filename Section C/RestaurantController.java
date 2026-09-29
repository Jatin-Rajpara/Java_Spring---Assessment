package com.jatin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jatin.dao.RestaurantDAO;
import com.jatin.model.Restaurant;

import jakarta.servlet.http.HttpSession;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantDAO dao;

    @RequestMapping("/restaurants")
    public ModelAndView restaurants(HttpSession session) {

        if (session.getAttribute("username") == null) {
            return new ModelAndView("redirect:/login.jsp");
        }

        List<Restaurant> restaurants = dao.getAllRestaurants();

        ModelAndView mv = new ModelAndView("restaurants");
        mv.addObject("restaurants", restaurants);

        return mv;
    }
}