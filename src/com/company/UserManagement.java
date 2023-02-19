package com.company;

import java.sql.*;

public class UserManagement implements InterManagement {
    public void register(Connection conn, String table_name, String name, String surname, int password, Integer cash) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name,surname,password, cash) values('%s','%s', '%s', '%s');", table_name,name, surname, password, cash);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Registered\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public boolean login(Connection conn, String table_name, String name, String surname, int password) {
        try {
            String query = String.format("SELECT * FROM %s WHERE name='%s' and surname='%s' and password='%s'", table_name, name, surname, password);
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

    public int getCashAmountForPerson(Connection conn, String table_name, String name, String surname, int password) {
        try {
            String query = "SELECT cash FROM person WHERE name = ? AND surname = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2,surname);
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
            statement.setDouble(1, newCash);
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