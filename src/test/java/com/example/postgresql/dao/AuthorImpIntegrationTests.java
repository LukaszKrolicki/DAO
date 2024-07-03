package com.example.postgresql.dao;

import com.example.postgresql.DAO.imp.AuthorImp;
import com.example.postgresql.TestDataUtil;
import com.example.postgresql.domain.Author;
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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // This annotation resets the database after each test
public class AuthorImpIntegrationTests {

    private AuthorImp underTest;

    @Autowired
    public AuthorImpIntegrationTests(AuthorImp underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRetrieved() {
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeRetrieved() {
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Author author2 = TestDataUtil.createTestAuthor2();
        underTest.create(author2);
        Author author3 = TestDataUtil.createTestAuthor3();
        underTest.create(author3);

        List<Author> result = underTest.findMany();
        assertThat(result).hasSize(3).contains(author, author2, author3);
    }


    @Test
    public void testUpdate(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        author.setName("Jane Doe");
        author.setAge(40);
        underTest.update(author, author.getId());
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testDelete(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        underTest.delete(author.getId());
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result.isEmpty()).isTrue();
    }
}
