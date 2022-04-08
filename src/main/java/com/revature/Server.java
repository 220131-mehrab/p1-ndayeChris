package com.revature;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    Logger logger = LoggerFactory.getLogger(Server.class);
    Tomcat server;

    // Run server
    public Server() throws JsonProcessingException, SQLException {
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        //"jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'";
        //new DatabaseController().BuildDatabase();
        // Default and Books Servlets
        server.addServlet("", "defServlet", new DefServlet()).addMapping("/*");
        server.addServlet("", "contactsServlet", new ContactsServlet(connection)).addMapping("/books");
    }


    public void run() {
        try {
            server.start();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
