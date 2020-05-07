package com.refactorizando.grpc.example.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TestDataUtil {

    private static List<Book> restBookList = new LinkedList<>();

    static {

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setAuthor(randomString());
            book.setBookType(Book.BookType.COMIC_BOOK);

            book.setKeyword(new LinkedList<>());
            for (int j = 0; j < 3; j++) {
                book.getKeyword().add(randomString());
            }

            book.setPage((int)(Math.random() * 100));
            book.setTitle(randomString());

            restBookList.add(book);

        }


    }

    private static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static List<Book> getRestTestData() {
        return restBookList;
    }
}
