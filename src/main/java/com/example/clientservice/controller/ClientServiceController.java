package com.example.clientservice.controller;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class ClientServiceController {
    private final ClientService clientService;
    private final Environment env;
    Logger logger;

    public ClientServiceController( ClientService clientService, Environment env) {
        this.env = env;
        this.clientService = clientService;
    }
    @RequestMapping("/")
    public String home() {
        String home = "Client-service running at port: "  + env.getProperty("local.server.port");
        logger.info(home);
        return home;
    }
    @RequestMapping(path = "/getAllBooksByFeignClient")
    public List<Book> getAllBooks(){
        logger.info("Calling through Feign Client");
        return clientService.getAllBooks();
    }

    @GetMapping(path = "/getAllBooksByRestTemplate")
    String data(){
        return clientService.data();
    }
}
