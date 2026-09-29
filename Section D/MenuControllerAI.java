package com.food.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.MenuItem;

@Controller
@RequestMapping("/menu")
public class MenuControllerAI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public ModelAndView listMenu() {

        String sql = "SELECT id, itemName, price, available FROM menu_items WHERE available = true";

        List<MenuItem> menuList = jdbcTemplate.query(sql, (rs, rowNum) -> {

            MenuItem item = new MenuItem();

            item.setId(rs.getInt("id"));
            item.setItemName(rs.getString("itemName"));
            item.setPrice(rs.getDouble("price"));
            item.setAvailable(rs.getBoolean("available"));

            return item;
        });

        ModelAndView mv = new ModelAndView("menu-list");

        mv.addObject("menuList", menuList);

        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addMenu(
            @RequestParam String itemName,
            @RequestParam double price,
            @RequestParam boolean available) {

        String sql = "INSERT INTO menu_items (itemName, price, available) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, itemName, price, available);

        ModelAndView mv = new ModelAndView("menu-list");

        mv.addObject("message", "Menu item added successfully");

        return mv;
    }
}
