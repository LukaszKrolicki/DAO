package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.BookDAO;
import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class BookImp implements BookDAO {

    private final JdbcTemplate jdbcTemplate;
    public BookImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (isbn, author_id, title) VALUES (?, ?, ?)",
                book.getIsbn(), book.getAuthorId(),book.getTitle()
        );
    }

    @Override
    public Optional<Book> findOne(String isbn) {
        List<Book> results = jdbcTemplate.query(
                "SELECT * FROM books WHERE isbn = ?",
                new BookRawMapper(), isbn
        );

        return results.stream().findFirst();
    }

    @Override
    public List<Book> findMany() {
        return jdbcTemplate.query(
                "SELECT * FROM books",
                new BookRawMapper()
        );
    }

    @Override
    public void update(Book book, String isbn) {
        jdbcTemplate.update(
                "UPDATE books SET author_id = ?, title = ? WHERE isbn = ?",
                book.getAuthorId(), book.getTitle(), isbn
        );
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
