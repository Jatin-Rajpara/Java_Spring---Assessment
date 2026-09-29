package com.jatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jatin.dao.OrderDAO;
import com.jatin.model.Order;

import jakarta.servlet.http.HttpSession;

@Controller
public class PlaceOrderController {

    @Autowired
    OrderDAO dao;

    @RequestMapping("/place")
    public ModelAndView placeOrder(
            @RequestParam("rId") int rId,
            @RequestParam("iName") String iName,
            @RequestParam("qty") int qty,
            @RequestParam("cName") String cName,
            HttpSession session) {

        if (session.getAttribute("username") == null) {
            return new ModelAndView("redirect:/login.jsp");
        }

        Order o = new Order(rId, iName, qty, cName);

        dao.placeOrder(o);

        return new ModelAndView("order-confirmation");
    }
}