package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.BookDAO;
import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Book> findOne(long l) {
        List<Book> results = jdbcTemplate.query(
                "SELECT * FROM book WHERE id = ?",
                new BookRawMapper(),
                l
        );

        return results.stream().findFirst();
    }

    public static class BookRawMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .authorId(rs.getLong("author_id"))
                    .title(rs.getString("title"))
                    .build();
        }
    }


}
