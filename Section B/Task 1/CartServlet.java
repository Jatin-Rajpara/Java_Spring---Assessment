package com.jatin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");

-->(Session ke andar "cart" naam se jo data rakha hai, wo mujhe do.
    Lekin getAttribute() normally Object return karta hai. Hume ArrayList<String> chahiye, isliye:)


        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        HttpSession session = request.getSession();

        if ("clear".equals(action)) {
            session.invalidate();
            response.sendRedirect("confirmation.jsp");
            return;
        }

        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");

        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        cart.add(quantity + "x " + name);

        response.sendRedirect("cart");
    }
}