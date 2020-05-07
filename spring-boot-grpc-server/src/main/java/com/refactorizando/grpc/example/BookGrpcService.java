package com.refactorizando.grpc.example;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
@Slf4j
public class BookGrpcService extends BookServiceGrpc.BookServiceImplBase {

    @Override
    public void createBooks(BookList request, StreamObserver<BookList> responseObserver) {
        log.debug("Request " + request);

        BookList.Builder responseBuilder = BookList.newBuilder();

        BookUtil.assignISBN(request.getBookList()).forEach(responseBuilder::addBook);

        BookList bookListResponse = responseBuilder.build();

        log.debug("Response " + bookListResponse);

        responseObserver.onNext(bookListResponse);
        responseObserver.onCompleted();
    }

}
