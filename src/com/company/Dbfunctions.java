package com.company;

import java.sql.*;
import java.util.Properties;

public class Dbfunctions extends User {

    public static Connection connect_to_db(String dbName, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/" + dbName;
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            conn = DriverManager.getConnection(url, props);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL driver not found.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
        return conn;
    }


    public static void register(Connection conn, String table_name, String name, String surname, Integer password, Integer cash) {
        Statement statement;
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setCash(cash);
        try {
            String query = String.format("insert into %s(name,surname,password, cash) values('%s','%s', '%s', '%s');", table_name, user.getName(), user.getSurname(), user.getPassword(), user.getCash());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Registered\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean login(Connection conn, String table_name, String name, String surname, int password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        try {
            String query = String.format("SELECT * FROM %s WHERE name='%s' and surname='%s' and password='%s'", table_name, user.getName(), user.getSurname(), user.getPassword());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
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

    public static int get_price_hotel(Connection conn, String table_name, Integer number_id_hotel) {
        Statement statement;
        ResultSet res;
        try {
            String query = String.format("select * from %s where id= '%s'", table_name, number_id_hotel);
            statement = conn.createStatement();
            res = statement.executeQuery(query);
            while (res.next()) {
                return res.getInt("price");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static int getCashAmountForPerson(Connection conn, String tableName, String name, String surname, int password) {
        try {
            String query = "SELECT cash FROM " + tableName + " WHERE name = ? AND surname = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("cash");
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve cash amount: " + e.getMessage());
        }
        return 0;
    }

    public void updateCash(Connection conn, int newCash, int oldCash, String name, String surname, int password) {
        try {
            String query = "UPDATE person SET cash = ? WHERE name = ? AND surname = ? AND password = ? AND cash = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, newCash);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setInt(4, password);
            statement.setInt(5, oldCash);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Data Updated");
            } else {
                System.out.println("No data was updated");
            }
        } catch (SQLException e) {
            System.err.println("Failed to update cash amount: " + e.getMessage());
        }
    }

}