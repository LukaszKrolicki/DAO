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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
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
}
