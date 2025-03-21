/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Trong Tinh
 */
public class Demo {
    public static void main(String[] args){
        System.out.println("Get data from database");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123");           
            Statement stm = con.createStatement();
            
            String sql= "SELECT * FROM EMPLOYEES";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1)+ "-" + rs.getString("FIRST"));
            }
            rs.close();stm.close();con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
