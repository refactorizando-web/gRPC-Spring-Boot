package com.refactorizando.grpc.example.rest;

import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.refactorizando.grpc.example.BookUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BooksRestController {

  private final HttpMessageConverters httpMessageConverters;

  @PostMapping("book")
  public List<Book> createBooks(@RequestBody List<Book> books) {

    books.forEach(book -> {
      book.setISBN(BookUtil.generateISBN());
    });

    return books;
  }

  @GetMapping()
  public void test() {
    httpMessageConverters.getConverters().forEach(System.out::println);
  }

}
