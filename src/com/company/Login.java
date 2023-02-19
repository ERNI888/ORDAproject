package com.company;
import java.sql.Connection;
import java.util.Scanner;
public class Login extends User{
    Scanner scan = new Scanner(System.in);
    Dbfunctions db = new Dbfunctions();
    UserManagement userM = new UserManagement();
    Register register = new Register();
    Connection conn = db.connectToDb("postgres","postgres","123");
    public void login() {
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Enter your password:");
        int password = scan.nextInt();

        boolean isLoginSuccessful = userM.login(conn, "person", name, surname, password);
        if (isLoginSuccessful) {
            System.out.println("\nYOU SUCCESSFULLY LOGIN AND WE HAVE SOME OFFERS FOR YOU");
            int cashofperson = userM.getCashAmountForPerson(conn, "person", name, surname, password);
            System.out.println("YOUR CASH NOW: " + cashofperson);

            register.processHotelBooking(conn, scan, name, surname, password, cashofperson);

        } else {
            System.out.println("MAYBE YOUR NAME/SURNAME/PASSWORD IS WRONG");
        }
    }
}
