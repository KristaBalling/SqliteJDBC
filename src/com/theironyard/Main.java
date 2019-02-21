package com.theironyard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

    try {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Krista\\IdeaProjects\\testdb\\testjava.db");
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                " (name TEXT, phone INTEGER, email TEXT)");
//        statement.execute("INSERT INTO contacts (name, phone, email)" +
//                "VALUES('Joe', 9834736, 'joe@anywhere.com')");
//
//        statement.execute("INSERT INTO contacts (name, phone, email)" +
//                "VALUES('Jane', 2849573, 'jane@somewhere.com')");
//
//        statement.execute("INSERT INTO contacts (name, phone, email)" +
//                "VALUES('Fido', 2948262, 'dog@anywhere.com')");
        statement.execute("UPDATE contacts SET phone=5555555 WHERE name='Jane'");
        statement.execute("DELETE FROM contacts WHERE name='Joe'");


        statement.close();
        conn.close();

    } catch(SQLException e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }
    }
}
