package com.jatin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jatin.dao.OrderDAO;
import com.jatin.model.Order;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderDAO dao;

    @RequestMapping("/list")
    public ModelAndView listOrders() {

        List<Order> orders = dao.getAllOrders();

        ModelAndView mv = new ModelAndView("orders-list");
        mv.addObject("orders", orders);

        return mv;
    }

    @RequestMapping("/place")
    public ModelAndView placeOrder(Order order) {

        dao.insertOrder(order);

        return new ModelAndView("redirect:/orders/list");
    }
}