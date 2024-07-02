package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.BookDAO;
import com.example.postgresql.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookImp implements BookDAO {

    private final JdbcTemplate jdbcTemplate;
    public BookImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book (id, author_id, title) VALUES (?, ?, ?)",
                book.getIsbn(), book.getAuthorId(), book.getTitle()
        );
    }
}
