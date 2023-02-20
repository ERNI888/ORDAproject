package com.company;

import java.sql.*;
import java.util.Properties;

public class Dbfunctions {

    public static Connection connectToDb(String dbName, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/" + dbName;
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            conn = DriverManager.getConnection(url, props);
//            if (conn != null) {
//                System.out.println("Connection Established");
//            } else {
//                System.out.println("Connection Failed");
//            }
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL driver not found.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
        return conn;
    }




    public void search_by_country(Connection conn, String table_name, String arrival) {
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where arrival= '%s'", table_name, arrival);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id") +
                        " | Arrival: " + rs.getString("arrival") +
                        " | Price: " + rs.getDouble("price") +
                        " | Date: " + rs.getString("date") +
                        " | Hotel Name: " + rs.getString("hotel_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }





    public static void userInfo(Connection conn, String table_name, String password) {
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where password= '%s'", table_name, password);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(" | Name: " + rs.getString("name"));
                System.out.println(" | Surname: " + rs.getString("surname"));
                System.out.println(" | Password: " + rs.getInt("password"));
                System.out.println(" | Cash: " + rs.getInt("cash"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}