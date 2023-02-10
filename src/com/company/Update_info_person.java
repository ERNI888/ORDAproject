//package com.company;
//
//import java.sql.Connection;
//import java.sql.Statement;
//
//public class Update_info_person {
//    public int cashperson;
//    public int pricetourr;
//
//    public void setCashperson(int cashperson) {
//        this.cashperson = cashperson;
//    }
//
//    public int getCashperson() {
//        return cashperson;
//    }
//
//    public void setPricetourr(int pricetourr) {
//        this.pricetourr = pricetourr;
//    }
//
//    public int getPricetourr() {
//        return pricetourr;
//    }
//
////    public void update_info_person(Connection conn, String table_name, String old_name, String new_name){
////        Statement statement;
////        try {
////            int new_cash = cashperson - pricetourr;
////            String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
////            statement=conn.createStatement();
////            statement.executeUpdate(query);
////            System.out.println("Data Updated");
////        }catch (Exception e){
////            System.out.println(e);
////        }
////    }
//}
