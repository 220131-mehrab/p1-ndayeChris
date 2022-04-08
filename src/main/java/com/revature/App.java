package com.revature;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class App {
    public static void main(String[] args) throws SQLException {
        try {
            new Server().run();
        } catch (JsonProcessingException e) {
            System.err.println("Server failed to run");
        }
    }
}
