package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    private static final  Dbfunctions db = new Dbfunctions();
    public static void main(String[] args) {
        Connection conn = db.connect_to_db("Tour", "postgres", "123");
        Scanner scan = new Scanner(System.in);
        Dbfunctions db = new Dbfunctions();
        //db.createTable(conn, "era");


        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");

        int number = scan.nextInt();
        scan.nextLine();
        if(number == 2){
            login();
            checkLogin();
        }else{
            checkLogin();
        }
    }

    private static void checkLogin(){
        scan.nextLine();
        Connection conn = db.connect_to_db("Tour", "postgres", "123");
        System.out.print("LOGIN FORM:\n");
        System.out.print("Your Name:");
        String name = scan.nextLine();
        System.out.print("Enter Your Surname:");
        String address = scan.nextLine();
        db.login(conn,"kokokoko" , name , address);
    }
    private static void login(){
        Connection conn = db.connect_to_db("Tour", "postgres", "123");
        System.out.print("Register FORM:\n");
        System.out.print("Your Name:");
        String name = scan.nextLine();
        System.out.print("Your Surname:");
        String address = scan.nextLine();
        System.out.println("How much money do you have?");
        int cash = scan.nextInt();
        db.register(conn,"kokokoko",name,address,cash);

    }
}