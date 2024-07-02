package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.AuthorDAO;
import com.example.postgresql.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorImp implements AuthorDAO {
    private final JdbcTemplate jdbcTemplate;

    public AuthorImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO author (id, name, age) VALUES (?, ?, ?)",
                author.getId(), author.getName(), author.getAge()
        );
    }
}
