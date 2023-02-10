package com.company;

public class User {
    public static String name;
    public static String surname;
    public static int cash;
//
//    public User() {
//        this.name = name;
//        this.surname = surname;
//        this.cash = cash;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
