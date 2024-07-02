package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.BookDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookImp implements BookDAO {

    private final JdbcTemplate jdbcTemplate;
    public BookImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
