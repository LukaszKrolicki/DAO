package com.example.postgresql.DAO;

import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;

import java.util.Optional;

public interface BookDAO {
    void create(Book book);

    Optional<Book> findOne(long l);
}
