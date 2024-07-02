package com.example.postgresql;

import com.example.postgresql.domain.Author;
import com.example.postgresql.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {
    }


    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("John Doe").age(30).build();
    }

    public static Author createTestAuthor2() {
        return Author.builder().id(2L).name("John Do").age(30).build();
    }

    public static Author createTestAuthor3() {
        return Author.builder().id(3L).name("John D").age(30).build();
    }

    public static Book createBook() {
        return Book.builder().isbn("xd").title("Book Title").authorId(1L).build();
    }
}
