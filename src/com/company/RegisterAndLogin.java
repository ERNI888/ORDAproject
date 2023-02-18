package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class RegisterAndLogin extends User {
    static User user = new User();
    static Scanner scan = new Scanner(System.in);
    static Dbfunctions db =new Dbfunctions();
    static Connection conn= Dbfunctions.connect_to_db("postgres","postgres","shisuimykty1006");
    public static void register() {
        System.out.print("\nREGISTRATION FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Create password:");
        int password = scan.nextInt();
        System.out.print("How much money do you have?:");
        int cash = scan.nextInt();

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setCash(cash);

        Dbfunctions.register(conn, "person", user.getName(), user.getSurname(), user.getPassword(), user.getCash());
    }

    public static void processHotelBooking(Connection conn, Scanner scan, String name, String surname, int password, int cashofperson) {
        SearchByCountry.searchByCountry();

        System.out.println("WRITE ID OF HOTEL:");
        Integer write_id_hotel = scan.nextInt();
        scan.nextLine();
        int priceofhotel = Dbfunctions.get_price_hotel(conn, "tur", write_id_hotel);
        System.out.println("THE PRICE OF THIS HOTEl: " + priceofhotel + " AND YOU HAVE:" + cashofperson);

        System.out.println("\nDO YOU CONFIRM YOUR HOTEL? YES==1/NO==2");
        int confirm = scan.nextInt();
        if (confirm == 1) {
            if (priceofhotel > cashofperson) {
                System.out.println("YOU HAVE LESS MONEY, SORRY");
            } else if (priceofhotel < cashofperson) {
                int remains = cashofperson - priceofhotel;
                db.updateCash(conn, remains, cashofperson, name, surname, password);
                System.out.println("YOU SUCCESSFULLY BOUGHT");
            } else {
                System.out.println("ERROR 404");
            }
        } else if (confirm == 2) {
            System.out.println("Choose again?:\n1)Yes==1\n2)No==2");
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    processHotelBooking(conn, scan, name, surname, password, cashofperson);
                case 2:
                    System.out.println("Okay, see u soon!");
            }
        }

    }

    public static void checkLogin() {
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Enter your password:");
        int password = scan.nextInt();

        boolean isLoginSuccessful = Dbfunctions.login(conn, "person", name, surname, password);
        if (isLoginSuccessful) {
            int cashofperson = Dbfunctions.getCashAmountForPerson(conn, "person", name, surname, password);
            System.out.println("YOUR CASH NOW: " + cashofperson);

            processHotelBooking(conn, scan, name, surname, password, cashofperson);

        } else {
            System.out.println("MAYBE YOUR NAME/SURNAME/PASSWORD IS WRONG");
        }
    }

}

