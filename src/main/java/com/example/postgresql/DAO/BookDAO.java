package com.example.postgresql.DAO;

import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    void create(Book book);

    Optional<Book> findOne(String l);

    List<Book> findMany();

    void update(Book book, String isbn);

    void delete(String xd);
}
