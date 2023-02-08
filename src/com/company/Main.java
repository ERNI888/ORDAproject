package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db =new Dbfunctions();
        Connection conn=db.connect_to_db("ordadb","postgres","12345678");
        //db.createTable(conn,"kokokoko");

        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");

        int number = scan.nextInt();
        if(number==1){
            System.out.print("Your Name:");
            String name = scan.nextLine();
            System.out.println("\nYour Address:");
            String address = scan.nextLine();
            db.insert_row(conn,"kokokoko",name,address);
        }
        else{
            System.out.println("OK");
        }
    }
}