package com.example.postgresql.dao;

import com.example.postgresql.DAO.imp.BookImp;
import com.example.postgresql.TestDataUtil;
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
        Book book = TestDataUtil.createBook();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, author_id, title) VALUES (?, ?, ?)"),
                eq("xd"), eq(1L), eq("Book Title"));
    }

    @Test
    public void TestThatFindOneGeneratesCorrectSQL() {
        underTest.findOne("xd");

        verify(jdbcTemplate).query(
                eq("SELECT * FROM books WHERE isbn = ?"), ArgumentMatchers.<BookImp.BookRawMapper>any(), eq("xd")
        );
    }

    @Test
    public void testUpdate(){
        Book book = TestDataUtil.createBook();
        underTest.create(book);
        book.setAuthorId(2L);
        book.setTitle("New Title");

        underTest.update(book, "xd");

        verify(jdbcTemplate).update(
                eq("UPDATE books SET author_id = ?, title = ? WHERE isbn = ?"),
                eq(2L), eq("New Title"), eq("xd")
        );
    }
}
