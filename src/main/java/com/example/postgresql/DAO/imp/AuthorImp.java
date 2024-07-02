package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.AuthorDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorImp implements AuthorDAO {
    private final JdbcTemplate jdbcTemplate;

    public AuthorImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
