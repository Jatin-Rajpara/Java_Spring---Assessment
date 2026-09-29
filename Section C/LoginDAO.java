package com.jatin.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAO {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean validateUser(String username, String password) {

        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

        int count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                username,
                password
        );

        if (count > 0) {
            return true;
        }

        return false;
    }
}