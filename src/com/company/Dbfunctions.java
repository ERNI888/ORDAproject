package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class Dbfunctions {
    User person = new User();

    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(empid SERIAL primary key ,name varchar(200),surename varchar(200), cash integer(20));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void register(Connection conn, String table_name, String name, String surname, Integer password, Integer cash) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name,surname,password, cash) values('%s','%s', '%s', '%s');", table_name, name, surname, password, cash);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Registered\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean login(Connection conn, String table_name, String name, String surname, Integer password) {
        try {
            String query = String.format("SELECT * FROM %s WHERE name='%s' and surname='%s' and password='%s'", table_name, name, surname, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                //  System.out.println("Yeah, you have an account\n");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } // public String not = "You did not register";

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
        ResultSet res = null;
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

    public static int get_cash_person(Connection conn, String table_name, String name, String surname, Integer password) {
        Statement statement;
        ResultSet ress = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE name='%s' and surname='%s' and password='%s'", table_name, name, surname, password);
            statement = conn.createStatement();
            ress = statement.executeQuery(query);
            while (ress.next()) {
                return ress.getInt("cash");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void update_cash(Connection conn, Integer new_cash, Integer old_cash, String name, String surname, Integer password) {
        Statement statement;
        try {
            String query = String.format("UPDATE person SET cash='%s' where cash='%s' and name='%s' and surname='%s' and password='%s'", new_cash, old_cash, name, surname, password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
