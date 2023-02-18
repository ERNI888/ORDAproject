package com.company;

import java.util.Scanner;
public class Main  {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        db.createTable(conn,"per");
        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");


        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 : RegisterAndLogin.checkLogin();
            case 2 : {
                RegisterAndLogin.register();
                RegisterAndLogin.checkLogin();
            }
        }
     }
}

