package com.example.postgresql.DAO.imp;

import com.example.postgresql.DAO.AuthorDAO;
import com.example.postgresql.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorImp implements AuthorDAO {
    private final JdbcTemplate jdbcTemplate;

    public AuthorImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
                author.getId(), author.getName(), author.getAge()
        );
    }

    @Override
    public Optional<Author> findOne(long l) {
        List<Author> results = jdbcTemplate.query(
                "SELECT * FROM authors WHERE id = ?",
                new AuthorRawMapper(),
                l
        );

        return results.stream().findFirst();
    }

    public static class AuthorRawMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }


}
