package com.company;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dbfunctions db=new Dbfunctions();
        Connection conn=db.connect_to_db("ordadb","postgres","12345678");
        db.createTable(conn,"");
    }
}