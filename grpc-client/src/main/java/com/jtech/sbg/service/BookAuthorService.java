package com.jtech.sbg.service;

import com.google.protobuf.Descriptors;
import com.jtech.api.Author;
import com.jtech.api.AuthorRequest;
import com.jtech.api.BookAuthorServiceGrpc;
import com.jtech.sbg.mapper.BookAuthorMapper;
import com.jtech.sbg.model.AuthorModel;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookAuthorService {
    private static Logger LOGGER = LoggerFactory.getLogger(BookAuthorService.class);

    @GrpcClient("grpc-server-service")
    BookAuthorServiceGrpc.BookAuthorServiceBlockingStub blockingStub;

    @Autowired
    BookAuthorMapper bookAuthorMapper;

    public ResponseEntity<AuthorModel> getAuthor(int authorId){
        try{
            Author author = blockingStub.getAuthor(AuthorRequest.newBuilder().setAuthorId(authorId).build());
            return new ResponseEntity<>(bookAuthorMapper.toAuthorModel(author), HttpStatus.OK) ;
        }
        catch (StatusRuntimeException ex){
            LOGGER.error(ex.getStatus().getDescription());
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
