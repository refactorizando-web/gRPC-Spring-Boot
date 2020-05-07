package com.refactorizando.grpc.example.rest;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    public enum BookType {COMIC_BOOK};

    private String ISBN;
    private String author;
    private String title;
    private int page;
    private List<String> keyword;
    private BookType bookType;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }




}
