package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Login login = new Login();
    static Register register = new Register();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello it's OrdaTour!");
        System.out.println("Do you have account?");
        System.out.println("1) Yes, log in");
        System.out.println("2) No, create account");


        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1:
                login.login();
                break;
            case 2:
                register.register();
                login.login();
                break;
        }
    }
}

