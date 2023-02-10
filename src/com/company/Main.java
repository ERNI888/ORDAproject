package com.company;

import java.sql.Connection;
import java.util.Scanner;
public class Main extends RegisterAndLogin {
    static Scanner scan = new Scanner(System.in);
    RegisterAndLogin reglog = new RegisterAndLogin();
    Dbfunctions db = new Dbfunctions();
    SearchByCountry sbc = new SearchByCountry();
    Connection conn = db.connect_to_db("postgres", "postgres", "shisuimykty1006");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RegisterAndLogin reglog = new RegisterAndLogin();
        Dbfunctions db = new Dbfunctions();
        SearchByCountry sbc = new SearchByCountry();
        Connection conn = db.connect_to_db("postgres", "postgres", "shisuimykty1006");
//        db.createTable(conn,"per");
        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");


        int number = scan.nextInt();
        scan.nextLine();
        switch (number){
            case 1:
                if(checkLogin()) {
                    SearchByCountry.searchByCountry();
                }
                break;
            case 2:
                register();

                if(checkLogin()) {
                    System.out.println("yes you have account, there is list of countries");
                    SearchByCountry.searchByCountry();
                }
                else {
                    System.out.println("you dont have account");
                }
                break;
            default:
                return;
        }
    }
}