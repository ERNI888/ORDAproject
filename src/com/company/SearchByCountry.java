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

        String write_name_country = scan.next();
        scan.nextLine();
        db.search_by_country(conn, "tur", write_name_country);
        }


}
