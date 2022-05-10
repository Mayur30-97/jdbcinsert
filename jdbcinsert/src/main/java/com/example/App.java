package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 */
public final class App {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

            String query="insert into test1 values(?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, "kiran");
            ps.setInt(2, 26);
            ps.setInt(3, 500000);
            ps.setString(4, "IT");
            

            if(ps.execute())
            {
                System.out.println("Inserted");
            }

            con.close();
        } catch (SQLException | ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
    }
}
