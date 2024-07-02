package com.example.postgresql.dao;

import com.example.postgresql.DAO.imp.AuthorImp;
import com.example.postgresql.TestDataUtil;
import com.example.postgresql.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
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
}
