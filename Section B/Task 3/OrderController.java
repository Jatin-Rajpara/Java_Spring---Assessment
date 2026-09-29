package com.jatin.controller;

import java.io.IOException;
import java.util.List;

import com.jatin.dao.OrderDAO;
import com.jatin.dao.OrderDAOImpl;
import com.jatin.model.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orders")
public class OrderController extends HttpServlet {

    OrderDAO dao = new OrderDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String customerName = request.getParameter("customerName");
        String restaurantName = request.getParameter("restaurantName");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
        String status = request.getParameter("status");

        Order order = new Order(
                orderId,
                customerName,
                restaurantName,
                totalAmount,
                status
        );

        dao.placeOrder(order);

        response.sendRedirect("confirmation.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Order> orders = dao.getAllOrders();

        request.setAttribute("orders", orders);

        RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
        rd.forward(request, response);
    }
}