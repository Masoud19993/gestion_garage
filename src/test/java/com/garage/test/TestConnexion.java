package com.garage.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnexion {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=garage_db;encrypt=false",
                "garage_user",
                "Garage"
            );

            System.out.println("✅ Connexion SQL Server OK");
            conn.close();

        } catch (Exception e) {
            System.out.println("❌ Connexion SQL Server FAILED");
            e.printStackTrace();
        }
    }
}
