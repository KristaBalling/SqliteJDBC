package com.theironyard;

import java.sql.*;

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
         statement.execute("SELECT * FROM contacts");
        ResultSet results = statement.getResultSet();
        while(results.next()) {
            System.out.println(results.getString("name") + " " +
                    results.getInt("phone") + " " +
                    results.getString("email"));
        }

        statement.close();
        conn.close();

    } catch(SQLException e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }
    }
}
