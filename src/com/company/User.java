package com.company;

public class User {
    public static String name;
    public static String surname;
    public static int password;
    public static int cash;


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

    public void setPassword(int password) {
        User.password = password;
    }

    public int getPassword() {
        return password;
    }
}


