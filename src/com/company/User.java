package com.company;

import java.sql.Connection;
import java.util.Scanner;

import static com.company.Dbfunctions.userInfo;

public class User {
    private static String name;
    private static String surname;
    private static int password;
    private static int cash;


    public static void user() {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db = new Dbfunctions();
        Connection conn = Dbfunctions.connectToDb("postgres", "postgres", "123");
        System.out.println("1)My profile");
        System.out.println("2)Exit");
        int confirm = scan.nextInt();
        if(confirm==1){
            System.out.println("Enter your password:");
            String write_password = scan.next();
            scan.nextLine();
            userInfo(conn, "person", write_password);

        }
        if(confirm==2){
            System.out.println("see u soon!");

        }

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setPassword(int password) {
        User.password = password;
    }

    public int getPassword() {
        return password;
    }
}


