package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactsServlet extends HttpServlet {
    // Connect to Database
    Connection connection;

    public ContactsServlet(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Contacts> contacts = new ArrayList<>();
        try {
            ResultSet rs = connection.prepareStatement("select * from contacts").executeQuery();
            while (rs.next()) {
                contacts.add(new Contacts(rs.getInt("ContactId"), rs.getString("Name"), rs.getString("Email"), rs.getString("PhoneNumber")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve from db: " + e.getSQLState());
        }

        // Get a JSON Mapper
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(contacts);
        resp.setContentType("application/json");
        resp.getWriter().println(results);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Contacts newContact = mapper.readValue(req.getInputStream(), Contacts.class);
        System.out.println(newContact);
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into contacts values (?, ?, ?, ?)");
            stmt.setInt(1, newContact.getContact_id());
            stmt.setString(2, newContact.getName());
            stmt.setString(2, newContact.getEmail());
            stmt.setString(2, newContact.getPhone_number());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert: " + e.getMessage());
        }
    }
}
