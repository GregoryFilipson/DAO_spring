package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class NameController {
    private final CustomersRepository repository;

    public NameController(CustomersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getListProductName(String name) throws IOException {
        return repository.getProductName(name);
    }
}
