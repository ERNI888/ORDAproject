package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Register extends UserManagement {
    Scanner scan = new Scanner(System.in);
    Dbfunctions db =new Dbfunctions();
    SearchByCountry search = new SearchByCountry();
    CashManagement cashM = new CashManagement();
    UserManagement userM  = new UserManagement();
    Connection conn= db.connectToDb("postgres","postgres","shisuimykty1006");


    public void register() {
        System.out.print("\nREGISTRATION FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Create password:");
        int password = scan.nextInt();
        System.out.print("How much money do you have?:");
        int cash = scan.nextInt();

        userM.register(conn, "person", name, surname, password, cash);
    }

    public void processHotelBooking(Connection conn, Scanner scan, String name, String surname, int password, int cashofperson) {
        search.searchByCountry();

        System.out.println("WRITE ID OF HOTEL:");
        Integer write_id_hotel = scan.nextInt();
        scan.nextLine();
        int priceofhotel;
        priceofhotel = cashM.getPriceHotel(conn, "tur", write_id_hotel);
        System.out.println("THE PRICE OF THIS HOTEl: " + priceofhotel + " AND YOU HAVE:" + cashofperson);

        System.out.println("\nDO YOU CONFIRM YOUR HOTEL? \nYES==1\nNO==2");
        int confirm = scan.nextInt();
        if (confirm == 1) {
            if (priceofhotel > cashofperson) {
                System.out.println("YOU HAVE LESS MONEY, SORRY");
            } else if (priceofhotel < cashofperson) {
                int remains = cashofperson - priceofhotel;
                userM.updateCash(conn, remains, cashofperson, name, surname, password);
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
                    break;
                case 2:
                    System.out.println("Okay, see u soon!");
                    break;
            }
        }
    }
}