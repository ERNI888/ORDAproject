package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class SearchByCountry{

    public static void searchByCountry() {
        Scanner scan = new Scanner(System.in);
        Dbfunctions db = new Dbfunctions();
        Connection conn = db.connect_to_db("postgres", "postgres", "shisuimykty1006");

        System.out.println("\nYOU SUCCESSFULLY LOGIN AND WE HAVE SOME OFFERS FOR YOU");
        System.out.println("Countries which you can arrive:");
        System.out.println("1) Dubai");
        System.out.println("2) Turkey");
        System.out.println("3) Japan");
        System.out.println("4) UK");
        System.out.println("5) Kazakhstan");

        int number = scan.nextInt();
//        scan.nextLine();
        switch (number) {
            case 1 -> db.search_by_country(conn, "tur", "Dubai");
            case 2 -> db.search_by_country(conn, "tur", "Turkey");
            case 3 -> db.search_by_country(conn, "tur", "Japan");
            case 4 -> db.search_by_country(conn, "tur", "UK");
            case 5 -> db.search_by_country(conn, "tur", "Kazakhstan");}
//        }  int number1 = scan.nextInt();
//
//            switch (number1) {
//                case 1:
//                    System.out.println("You have chosen a Single room.");
//                    // Code to book a single room
//                    break;
//                case "Double":
//                    System.out.println("You have chosen a Double room.");
//                    // Code to book a double room
//                    break;
//                case "Suite":
//                    System.out.println("You have chosen a Suite room.");
//                    // Code to book a suite room
//                    break;
//                case "Family":
//                    System.out.println("You have chosen a Family room.");
//                    // Code to book a family room
//                    break;
//                default:
//                    System.out.println("Sorry, this room type is not available.");
//                    break;
//            }
    }


}