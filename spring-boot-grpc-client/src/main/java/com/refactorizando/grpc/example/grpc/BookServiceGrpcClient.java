package com.refactorizando.grpc.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.util.RoundRobinLoadBalancerFactory;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

import com.refactorizando.grpc.example.Book;
import com.refactorizando.grpc.example.BookList;
import com.refactorizando.grpc.example.BookServiceGrpc;

@Service
@Slf4j
public class BookServiceGrpcClient {

    public BookList createBooks(List<Book> bookList) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .loadBalancerFactory(RoundRobinLoadBalancerFactory.getInstance())
                .usePlaintext(true)
                .build();

        BookServiceGrpc.BookServiceBlockingStub bookServiceBlockingStub = BookServiceGrpc.newBlockingStub(channel);

        BookList.Builder builder = BookList.newBuilder();
        bookList.forEach(builder::addBook);
        BookList request = builder.build();

        log.debug("Request " + request);
        BookList response = bookServiceBlockingStub.createBooks(request);
        log.debug("Response " + response);

        return response;

    }

}
