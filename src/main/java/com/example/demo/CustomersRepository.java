package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class CustomersRepository {
    final static String scriptName = "src/main/resources/script.sql";


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CustomersRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String read(String scriptName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(scriptName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    public List<String> getProductName(String name) throws IOException {
        String product_name = read(scriptName);
        return namedParameterJdbcTemplate.queryForList(product_name,
                new MapSqlParameterSource("name", name), String.class);
    }
}
