package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final BookServiceConnector connector;

    public ClientService(BookServiceConnector connector) {
        this.connector = connector;
    }
    public List<Book> getAllBooks() {
        return connector.getAllBooks();
    }

    public List<Book> data() {
        return 
    };

}
