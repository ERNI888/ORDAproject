package com.company;

import java.sql.Connection;
import java.util.Scanner;
public class Main extends RegisterAndLogin {
    static Scanner scan = new Scanner(System.in);
    RegisterAndLogin rg = new RegisterAndLogin();
    static Dbfunctions db = new Dbfunctions();
    static SearchByCountry sbc = new SearchByCountry();
    Connection conn = db.connect_to_db("postgres", "postgres", "pinokio");

    public static void main(String[] args) {
//        db.createTable(conn,"per");
        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");


        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 -> checkLogin();
            case 2 -> {
                register();
                checkLogin();
            }
            default -> {
                return;
            }
        }
     }
}

