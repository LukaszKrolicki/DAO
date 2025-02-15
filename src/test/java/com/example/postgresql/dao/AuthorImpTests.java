package com.example.postgresql.dao;

import com.example.postgresql.DAO.imp.AuthorImp;
import com.example.postgresql.TestDataUtil;
import com.example.postgresql.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorImpTests {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorImp underTest;

    @Test
    public void testThatCreatesAuthorGeneratesCorrectSQL() {
        Author author = TestDataUtil.createTestAuthor();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L),eq("John Doe"),eq(30)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSQL() {
        underTest.findOne(1L);

        verify(jdbcTemplate).query(
                eq("SELECT * FROM authors WHERE id = ?"), ArgumentMatchers.<AuthorImp.AuthorRawMapper>any(), eq(1L)
        );
    }

    @Test
    public void FindManyGeneratesCorrectSQL() {
        underTest.findMany();

        verify(jdbcTemplate).query(
                eq("SELECT * FROM authors"), ArgumentMatchers.<AuthorImp.AuthorRawMapper>any()
        );
    }

    @Test
    public void testThatUpdateOneGeneratesCorrectSQL() {
        Author author = TestDataUtil.createTestAuthor();

        underTest.update(author,3L);

        verify(jdbcTemplate).update(
                eq("UPDATE authors SET name = ?, age = ? WHERE id = ?"),
                eq("John Doe"),eq(30),eq(3L)
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSQL() {
        underTest.delete(1L);

        verify(jdbcTemplate).update(
                eq("DELETE FROM authors WHERE id = ?"), eq(1L)
        );
    }
}
