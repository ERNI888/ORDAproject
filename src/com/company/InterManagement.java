package com.company;

import java.sql.Connection;

public interface InterManagement {
        void register(Connection conn, String table_name, String name, String surname, int password, Integer cash);
        boolean login(Connection conn, String table_name, String name, String surname, int password);
        int getCashAmountForPerson(Connection conn, String table_name, String name, String surname, int password);
        void updateCash(Connection conn, int newCash, int oldCash, String name, String surname, int password);
}

