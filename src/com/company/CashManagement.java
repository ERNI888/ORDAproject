package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CashManagement  {


    public int getPriceHotel(Connection conn, String tableName, Integer hotelId) throws SQLException {
        Statement statement = null;
        ResultSet res;
        try {
            String query = String.format("SELECT price FROM %s WHERE id= '%s'", tableName, hotelId);
            statement = conn.createStatement();
            res = statement.executeQuery(query);
            while (res.next()) {
                return res.getInt("price");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            if(statement != null) {
                statement.close();
            }
        }
        return 0;
    }

}