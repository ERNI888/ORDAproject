package com.company;

import java.sql.Connection;
import java.util.Scanner;

import static com.company.Dbfunctions.userInfo;

public class Profile extends User {
    public static void profile() {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db = new Dbfunctions();
        Connection conn = Dbfunctions.connectToDb("postgres", "postgres", "shisuimykty1006");
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
}
