package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CashManagement  {


    public int getPriceHotel(Connection conn, String tableName, Integer hotelId) {
        Statement statement;
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
        return 0;
    }

}
