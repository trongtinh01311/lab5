/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Trong Tinh
 */
public class DemoPreparedStatement {
    public static void main(String[] args){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            
            String sql = "UPDATE EMPLOYEES SET AGE = ? WHERE ID = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, 40);
            stm.setInt(2, 7);
            int rows = stm.executeUpdate();
            System.out.println("Rows: " + rows);
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
