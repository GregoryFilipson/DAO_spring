package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class DAO_controller {
    private final CustomersRepository repository;

    public DAO_controller(CustomersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getListProductName(@RequestParam("name") String name) throws IOException {
        return repository.getProductName(name);
    }
}
