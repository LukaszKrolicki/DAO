package com.example.postgresql.DAO;

import com.example.postgresql.domain.Author;

import java.util.Optional;

public interface AuthorDAO {

    void create(Author author);

    Optional<Author> findOne(long l);
}
