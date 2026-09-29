package com.jatin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jatin.model.Order;

public class OrderDAOImpl implements OrderDAO {

    String url = "jdbc:mysql://localhost:3306/fooddb";
    String username = "root";
    String password = "root";

    @Override
    public void placeOrder(Order o) {

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, o.getOrderId());
            ps.setString(2, o.getCustomerName());
            ps.setString(3, o.getRestaurantName());
            ps.setDouble(4, o.getTotalAmount());
            ps.setString(5, o.getStatus());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int id) {

        Order order = null;

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM orders WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                order = new Order(
                        rs.getInt("order_id"),
                        rs.getString("customer_name"),
                        rs.getString("restaurant_name"),
                        rs.getDouble("total_amount"),
                        rs.getString("status")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orders = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM orders";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order order = new Order(
                        rs.getInt("order_id"),
                        rs.getString("customer_name"),
                        rs.getString("restaurant_name"),
                        rs.getDouble("total_amount"),
                        rs.getString("status")
                );

                orders.add(order);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public void updateStatus(int id, String status) {

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}