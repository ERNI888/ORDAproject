package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class SearchByCountry{

    public static void searchByCountry() {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db = new Dbfunctions();
        Connection conn = db.connect_to_db("postgres", "postgres", "pinokio");

        System.out.println("\nYOU SUCCESSFULLY LOGIN AND WE HAVE SOME OFFERS FOR YOU");
        System.out.println("Countries which you can arrive:");
        System.out.println("1) Dubai");
        System.out.println("2) Turkey");
        System.out.println("3) Japan");
        System.out.println("4) UK");
        System.out.println("5) Kazakhstan");

        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 -> db.search_by_country(conn, "tur", "Dubai");
            case 2 -> db.search_by_country(conn, "tur", "Turkey");
            case 3 -> db.search_by_country(conn, "tur", "Japan");
            case 4 -> db.search_by_country(conn, "tur", "UK");
            case 5 -> db.search_by_country(conn, "tur", "Kazakhstan");
        }

        }
    }
