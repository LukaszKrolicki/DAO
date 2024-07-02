package com.example.postgresql.dao;

import com.example.postgresql.DAO.imp.BookImp;
import com.example.postgresql.domain.Book;
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
public class BookDaoImpTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookImp underTest;

    @Test
    public void testThatCreatesBookGeneratesCorrectSQL() {
        Book book = Book.builder().isbn("xd").authorId(1L).title("Book Title").build();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO book (id, author_id, title) VALUES (?, ?, ?)"),
                eq("xd"), eq(1L), eq("Book Title"));
    }

    @Test
    public void TestThatFindOneGeneratesCorrectSQL() {
        underTest.findOne(1L);

        verify(jdbcTemplate).query(
                eq("SELECT * FROM book WHERE id = ?"), ArgumentMatchers.<BookImp.BookRawMapper>any(), eq(1L)
        );
    }
}
