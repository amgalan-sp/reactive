package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientService {
    private final BookServiceConnector connector;
    private static final Logger LOG = Logger.getLogger(ClientService.class.getName());
    private RestTemplate restTemplate;

    public ClientService(BookServiceConnector connector, RestTemplate template) {
        this.connector = connector;
        this.restTemplate = template;
    }
    public List<Book> getAllBooks() {
        return connector.getAllBooksList();
    }

    public String data() {
        String response = restTemplate.getForObject("http://book-service/data",String.class);
        LOG.log(Level.INFO, response);
        return response;
    };

}
