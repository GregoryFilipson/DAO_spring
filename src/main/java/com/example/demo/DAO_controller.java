package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DAO_controller {
    private final CustomersRepository repository;

    public DAO_controller(CustomersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getListProductName(String name) throws IOException {
        return repository.getProductName(name);
    }

    @GetMapping("/test")
    public String getListProductName() throws IOException {
        return "Hello";
    }

}
