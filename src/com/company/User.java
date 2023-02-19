package com.company;


abstract class User {
    private static String name;
    private static String surname;
    private static int password;
    private static int cash;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        User.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        User.surname = surname;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        User.cash = cash;
    }

    public void setPassword(int password) {
        User.password = password;
    }

    public int getPassword() {
        return password;
    }

}


