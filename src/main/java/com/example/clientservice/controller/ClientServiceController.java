package com.example.clientservice.controller;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class ClientServiceController {
    private ClientService clientService;
    Logger logger;

    public ClientServiceController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping(path = "/getAllBooksByFeignClient")
    public List<Book> getAllBooks(){
        logger.info("Calling through Feign Client");
        return clientService.getAllBooks();
    }

    @RequestMapping(path = "/getAllBooksByRestTemplate")
    List<Book> data(){
        return clientService.data();
    }
}
