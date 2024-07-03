package com.example.postgresql.dao;

import com.example.postgresql.DAO.AuthorDAO;
import com.example.postgresql.DAO.imp.AuthorImp;
import com.example.postgresql.DAO.imp.BookImp;
import com.example.postgresql.TestDataUtil;
import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookImpIntegrationTests {

    BookImp underTest;

    AuthorDAO authorDAO;
    @Autowired
    public BookImpIntegrationTests(BookImp underTest, AuthorDAO authorDAO) {
        this.underTest = underTest;
        this.authorDAO = authorDAO;
    }

    @Test
    public void testThatBookCanBeCreatedAndRetrieved() {
        Book book = TestDataUtil.createBook();
        Author author = TestDataUtil.createTestAuthor();
        authorDAO.create(author);
        book.setAuthorId(author.getId());
        underTest.create(book);

        Optional<Book> result = underTest.findOne(book.getIsbn());

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultpleBookCanBeCreatedAndRetrieved() {
        Book book2 = TestDataUtil.createBook2();
        Author author = TestDataUtil.createTestAuthor();
        authorDAO.create(author);
        underTest.create(book2);
        Author author2 = TestDataUtil.createTestAuthor2();
        authorDAO.create(author2);
        Book book3 = TestDataUtil.createBook3();
        underTest.create(book3);

        List<Book> result = underTest.findMany();

        assertThat(result).hasSize(2).contains(book2, book3);
    }

    @Test
    public void testUpdateBook(){
        Book book = TestDataUtil.createBook();
        Author author = TestDataUtil.createTestAuthor();
        Author author2=TestDataUtil.createTestAuthor2();
        authorDAO.create(author2);
        authorDAO.create(author);
        book.setAuthorId(author.getId());
        underTest.create(book);
        book.setAuthorId(2L);
        book.setTitle("New Title");

        underTest.update(book, book.getIsbn());

        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(book);
    }
}
