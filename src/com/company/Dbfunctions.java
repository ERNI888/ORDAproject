package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Dbfunctions {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
//            if(conn!=null){
//                System.out.println("Connection Established");
//            }
//            else{
//                System.out.println("Connection Failed");
            //}

        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query="create table "+table_name+"(empid SERIAL,name varchar(200),address varchar(200), cash integer(20), primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void register(Connection conn,String table_name,String name, String address, Integer cash){
        Statement statement;
        try {
            String query=String.format("insert into %s(name,address, cash) values('%s','%s', '%s');",table_name,name,address,cash);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Registered");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void login(Connection conn,String table_name,String name, String surname){
        try {
            String query = String.format("SELECT * FROM %s WHERE name='%s' and address='%s'", table_name, name, surname);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.println("Yeah, you have an account");
            } else {
                System.out.println("You did not register");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
