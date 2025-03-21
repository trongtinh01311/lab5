/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Trong Tinh
 */
public class DemoExecuteUpdate {
    public static void main(String[] args){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            
            Statement stm = con.createStatement();
            String sql = "DELETE FROM EMPLOYEES WHERE ID = 2";
            int rows = stm.executeUpdate(sql);
            System.out.println("Rows: " + rows);
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
