package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class RegisterAndLogin {
     static Scanner scan = new Scanner(System.in);
     static Dbfunctions db =new Dbfunctions();
     static Connection conn=db.connect_to_db("postgres","postgres","pinokio");
    public static void register(){
        scan.nextLine();
        System.out.print("\nREGISTRATION FORM:\n");
        System.out.print("Your Name:");
        String name = scan.nextLine();
        System.out.print("Your Surname:");
        String surname = scan.nextLine();
        System.out.print("Create password:");
        int password = scan.nextInt();
        System.out.print("How much money do you have?:");
        int cash = scan.nextInt();
        Dbfunctions.register(conn,"person",name,surname,password,cash);
    }

    public  static  boolean checkLogin(){
        scan.nextLine();
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your Name:");
        String name = scan.nextLine();
        System.out.print("Your Surname:");
        String surname = scan.nextLine();
        System.out.print("Enter your password:");

        int password = scan.nextInt();
        //Dbfunctions.login(conn,"person",name,surename,password);
        return Dbfunctions.login(conn,"person",name,surname,password);
    }
}
