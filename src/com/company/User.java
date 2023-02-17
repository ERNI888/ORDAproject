package com.company;

public class User {
    private String name;
    private String surname;
    private int cash;
    private int password;


    public User(String name, String surname, int cash, String gender) {
        this.name = name;
        this.surname = surname;
        this.cash = cash;

    }

    public User() {

    }

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


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
