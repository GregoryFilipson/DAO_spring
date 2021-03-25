package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class DAO_Repository {
    static String scriptName = "src/main/resources/script.sql";

    @Autowired
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static String read(String scriptName) throws IOException {
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

    public static List<String> getProductName(String name) throws IOException {
        String product_name = read(scriptName);
        return namedParameterJdbcTemplate.queryForList(product_name,
                Collections.singletonMap("name", name), String.class);
    }
}
