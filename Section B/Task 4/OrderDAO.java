package com.jatin.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jatin.model.Order;

public class OrderDAO {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertOrder(Order o) {

        String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                o.getOrderId(),
                o.getCustomerName(),
                o.getRestaurantName(),
                o.getTotal(),
                o.getStatus());
    }

    public List<Order> getAllOrders() {

        String sql = "SELECT * FROM orders";

        RowMapper<Order> rowMapper = (rs, rowNum) -> {

            Order order = new Order();

            order.setOrderId(rs.getInt("order_id"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setRestaurantName(rs.getString("restaurant_name"));
            order.setTotal(rs.getDouble("total_amount"));
            order.setStatus(rs.getString("status"));

            return order;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}