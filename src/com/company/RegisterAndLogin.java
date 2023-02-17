package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class RegisterAndLogin {
     static Scanner scan = new Scanner(System.in);
     static Dbfunctions db =new Dbfunctions();
     static SearchByCountry sbc = new SearchByCountry();
     static Connection conn=db.connect_to_db("postgres","postgres","123");
    public static void register(){
        System.out.print("\nREGISTRATION FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Create password:");
        int password = scan.nextInt();
        System.out.print("How much money do you have?:");
        int cash = scan.nextInt();
        Dbfunctions.register(conn,"person",name,surname,password,cash);
    }

    public static boolean checkLogin(){
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Enter your password:");
        Integer password = scan.nextInt();

        //Dbfunctions.login(conn,"person",name,surname,password);
        boolean isLoginSuccessful = Dbfunctions.login(conn,"person",name,surname,password);
        if (isLoginSuccessful) {
            int cashofperson = db.get_cash_person(conn,"person",name,surname,password);
            System.out.println("YOUR CASH NOW: " + cashofperson);
            SearchByCountry.searchByCountry();

            System.out.println("WRITE ID OF HOTEL:");
            Integer write_id_hotel = scan.nextInt();
            scan.nextLine();
            int priceofhotel = db.get_price_hotel(conn, "tur", write_id_hotel);
            System.out.println("THE PRICE OF THIS HOTEl: " + priceofhotel + " AND YOU HAVE:" + cashofperson);

            System.out.println("\nDO YOU CONFIRM YOUR HOTEL? YES==1/NO==2");
            int confirm = scan.nextInt();
            if(confirm == 1){
                if(priceofhotel>cashofperson){
                    System.out.println("YOU HAVE LESS MONEY, SORRY");
                }
                else if(priceofhotel<cashofperson){
                    int remains = cashofperson - priceofhotel;
                    db.update_cash(conn, remains, cashofperson, name,surname,password);
                    System.out.println("YOU SUCCESSFULLY BOUGHT");
                }
                else {
                    System.out.println("ERROR 404");
                }
            }
            else {
                System.out.println("Ok, see you soon");
            }
        }
        else{
            System.out.println("MAYBE YOUR NAME/SURNAME/PASSWORD IS WRONG");
        }
        return isLoginSuccessful;
    }
}


