package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db =new Dbfunctions();
        Connection conn=db.connect_to_db("postgres","postgres","pinokio");
//        db.createTable(conn,"per");

        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");

        int number = scan.nextInt();
        scan.nextLine();
        if(number == 2){
            register();
            checkLogin();
        }
        else if(number==1){
            checkLogin();
        }
        else {
            System.out.println("please, check again");
        }

        search_by_country();
    }

    private static void register(){
        Scanner scan = new Scanner(System.in);
        Dbfunctions db =new Dbfunctions();
        Connection conn=db.connect_to_db("postgres","postgres","pinokio");
        System.out.print("\nREGISTRATION FORM:\n");
        System.out.print("Your Name:");
        String name = scan.nextLine();
        System.out.print("Your Surname:");
        String surename = scan.nextLine();
        System.out.print("Create password:");
        int password = scan.nextInt();
        System.out.print("How much money do you have?:");
        int cash = scan.nextInt();
        db.register(conn,"person",name,surename,password,cash);

    }
    private static void checkLogin(){
        Scanner scan = new Scanner(System.in);
        Dbfunctions db =new Dbfunctions();
        Connection conn=db.connect_to_db("postgres","postgres","pinokio");
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your Name:");
        String name = scan.nextLine();
        System.out.print("Your Surname:");
        String surename = scan.nextLine();
        System.out.print("Enter your password:");
        int password = scan.nextInt();
        db.login(conn,"person",name,surename,password);
    }
    private static void search_by_country(){
        Scanner scan = new Scanner(System.in);
        Dbfunctions db =new Dbfunctions();
        Connection conn=db.connect_to_db("postgres","postgres","pinokio");

        System.out.println("\nYOU SUCCESSFULLY LOGIN AND WE HAVE SOME OFFERS FOR YOU");
        System.out.println("Countries which you can arrive:");
        System.out.println("1) Dubai");
        System.out.println("2) Turkey");
        System.out.println("3) Japan");
        System.out.println("4) UK");
        System.out.println("5) Kazakhstan");

        int number = scan.nextInt();
        scan.nextLine();
        switch (number){
            case 1: db.search_by_country(conn,"tur","Dubai");
                break;
            case 2: db.search_by_country(conn,"tur","Turkey");
                break;
            case 3: db.search_by_country(conn,"tur","Japan");
                break;
            case 4: db.search_by_country(conn,"tur","UK");
                break;
            case 5: db.search_by_country(conn,"tur","Kazakhstan");
                break;
        }

    }
}
