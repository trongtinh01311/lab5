/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trong Tinh
 */
public class QuanLyNhanVien extends javax.swing.JFrame {
    String head[] = {"Name", "Email", "Pass", "Country"};
    DefaultTableModel model = new DefaultTableModel(head, 0);
    /**
     * Creates new form QuanLyNhanVien
     */
    public QuanLyNhanVien() {
        initComponents();
        loadDataToJTable();
    }
    
    public void loadDataToJTable(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB_SLIDE6;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123");   
            
            Statement st = con.createStatement();
            String sql = "SELECT * FROM INFO";
            ResultSet  rs = st.executeQuery(sql);
            model.setRowCount(0);
            while(rs.next()){
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                model.addRow(row);
            }
            tblQLNhanVien.setModel(model);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void delete(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB_SLIDE6;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123"); 
            
            String sql = "DELETE FROM INFO WHERE UNAME = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txtName.getText());
            st.executeUpdate();
            con.close();
            loadDataToJTable();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void update(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB_SLIDE6;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123"); 
            
            String sql = "UPDATE INFO SET UEMAIL = ?, UPASS = ?, UCOUNTRY = ? WHERE UNAME = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txtEmail.getText());
            st.setString(2, txtPass.getText());
            st.setString(3, txtCountry.getText());
            st.setString(4, txtName.getText());
            st.executeUpdate();
            con.close();
            loadDataToJTable();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void save(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=EMPDB_SLIDE6;encrypt=false";
            Connection con = DriverManager.getConnection(url, "sa", "123"); 
            
            String sql = "INSERT INTO INFO VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txtName.getText());
            st.setString(2, txtEmail.getText());
            st.setString(3, txtPass.getText());
            st.setString(4, txtCountry.getText());
            st.executeUpdate();
            con.close();
            loadDataToJTable();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void aNew(){
        txtCountry.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtPass.setText("");
        txtName.requestFocus();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNhanVien = new javax.swing.JTable();
        bntNew = new javax.swing.JButton();
        bntSave = new javax.swing.JButton();
        bntUpdate = new javax.swing.JButton();
        bntDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("Name");

        jLabel3.setText("Email");

        jLabel4.setText("Pass");

        jLabel5.setText("Country");

        tblQLNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblQLNhanVien);

        bntNew.setText("New");
        bntNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNewActionPerformed(evt);
            }
        });

        bntSave.setText("Save");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        bntUpdate.setText("Update");
        bntUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdateActionPerformed(evt);
            }
        });

        bntDelete.setText("Delete");
        bntDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCountry))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtName)
                                            .addComponent(txtEmail)
                                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bntNew)
                                    .addComponent(bntSave)
                                    .addComponent(bntUpdate)
                                    .addComponent(bntDelete)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntNew))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSave))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntUpdate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNewActionPerformed
        // TODO add your handling code here:
        aNew();
    }//GEN-LAST:event_bntNewActionPerformed

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_bntSaveActionPerformed

    private void bntUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_bntUpdateActionPerformed

    private void bntDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_bntDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntDelete;
    private javax.swing.JButton bntNew;
    private javax.swing.JButton bntSave;
    private javax.swing.JButton bntUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQLNhanVien;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
