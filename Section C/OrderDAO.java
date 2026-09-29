package com.jatin.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jatin.model.Order;

public class OrderDAO {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void placeOrder(Order o) {

        String sql = "INSERT INTO food_orders (restaurant_id, item_name, quantity, customer_name) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                o.getrId(),
                o.getiName(),
                o.getQty(),
                o.getcName()
        );
    }
}