package com.food.controller;
// Fixed
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.MenuItem;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public ModelAndView listMenu() {

        String sql = "SELECT id, itemName, price, available FROM menu_items WHERE available = ?";

        List<MenuItem> menuList = jdbcTemplate.query(
                sql,
                new Object[]{true},
                (rs, rowNum) -> {

                    MenuItem item = new MenuItem();

                    item.setId(rs.getInt("id"));
                    item.setItemName(rs.getString("itemName"));
                    item.setPrice(rs.getDouble("price"));
                    item.setAvailable(rs.getBoolean("available"));

                    return item;
                });

        ModelAndView mv = new ModelAndView("menu-list");

        if (menuList == null || menuList.isEmpty()) {
            mv.addObject("message", "No menu items available");
        } else {
            mv.addObject("menuList", menuList);
        }

        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addMenu(
            @RequestParam("itemName") String itemName,
            @RequestParam("price") double price,
            @RequestParam("available") boolean available) {

        ModelAndView mv = new ModelAndView("menu-list");

        try {

            String sql = "INSERT INTO menu_items (itemName, price, available) VALUES (?, ?, ?)";

            jdbcTemplate.update(sql, itemName, price, available);

            mv.addObject("message", "Menu item added successfully");

        } catch (Exception e) {

            mv.addObject("message", "Error adding menu item");

        }

        return mv;
    }
}