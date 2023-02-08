package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db =new Dbfunctions();
        Connection conn=db.connect_to_db("ooooo","postgres","12345678");
//        db.createTable(conn,"per");

        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");

        int number = scan.nextInt();
        scan.nextLine();
        if(number==2){
            System.out.print("REGISTRATION FORM:");
            System.out.print("Your Name:");
            String name = scan.nextLine();
            System.out.print("Your Surname:");
            String address = scan.nextLine();
            System.out.print("How much money do you have?:");
            int cash = scan.nextInt();
            db.register(conn,"per",name,address,cash);

        }
        else if (number==1){
            System.out.print("LOGIN FORM:");
            System.out.print("Your Name:");
            String name = scan.nextLine();
            System.out.print("Your Surname:");
            String address = scan.nextLine();
            db.login(conn,"per",name,address);
        }
        else{
            System.out.println("Problem with login/registration");
        }
    }
}