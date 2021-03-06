/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objects.Referee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * UI to update referee records.
 * @author joshf
 */
public class Referees extends javax.swing.JFrame {

    /**
     * Creates new form Players
     */
    public Referees() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbName = new javax.swing.JComboBox<>();
        tfAddress = new javax.swing.JTextField();
        tfDOB = new javax.swing.JTextField();
        tfNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNameItemStateChanged(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel4.setText("Address:");

        jLabel5.setText("Date Of Birth");

        jLabel6.setText("Contact Number: ");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbName, 0, 168, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(tfNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addComponent(tfDOB))
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        RefereeEngine re = new RefereeEngine();
        Referee r = new Referee();
        
        r.Referee(null, null, tfAddress.getText(), Date.valueOf(tfDOB.getText()), tfNumber.getText());
        re.updateReferee(String.valueOf(cbName.getSelectedItem()), r);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNameItemStateChanged
        
        RefereeEngine re = new RefereeEngine();
        Referee r = new Referee();
        
        r = re.getReferee(String.valueOf(cbName.getSelectedItem()));
        
        tfAddress.setText(r.getAddress());
        tfDOB.setText(String.valueOf(r.getDateOfBirth()));
        tfNumber.setText(r.getTelephoneNumber());
    }//GEN-LAST:event_cbNameItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        RefereeEngine re = new RefereeEngine();
        
        re.deleteReferee(String.valueOf(cbName.getSelectedItem()));
        
        int currentItem = cbName.getSelectedIndex();
        
        cbName.removeItemAt(currentItem);
        
    }//GEN-LAST:event_btnDeleteActionPerformed
    /**
     * Adds all the referee names to the combo box.
     */
    public static void setRefereeNames(){
        
        RefereeEngine re = new RefereeEngine();
        String[] refereeNames;
        refereeNames = re.getRefereeNames();
        
        for(int i = 0; i < refereeNames.length; i++){
            
            cbName.addItem(refereeNames[i]);
            
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(Referees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Referees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Referees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Referees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Referees().setVisible(true);
                setRefereeNames();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private static javax.swing.JComboBox<String> cbName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfDOB;
    private javax.swing.JTextField tfNumber;
    // End of variables declaration//GEN-END:variables

    /**
     * Retrieves, edits and deletes referee details from DB.
     */
    protected static class RefereeEngine {
    
    private Connection con;
    private Statement stmnt;
    private ResultSet rs;
    private String SQL;
    
    /**
     * returns the selected referee.
     * @param refereeName
     * @return 
     */
    public Referee getReferee(String refereeName){
        
        Referee r = new Referee();
        int refereeID = getRefereeID(refereeName);
        
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.REFEREE WHERE referee_id = " + refereeID;
            rs = stmnt.executeQuery(SQL);
            
            rs.next();
            
            r.Referee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getDate("date_of_birth"),
                            rs.getString("telephone_number"));
            r.setRefereeID(rs.getInt("referee_id"));
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return r;
        
    }
    /**
     * Returns all referee names and id numbers.
     * @return 
     */
    public String[] getRefereeNames(){
        
        String[] refereeNames =  new String[0];
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.REFEREE";
            rs = stmnt.executeQuery(SQL);
            
            int i = -1;
            
            while(rs.next()){
                
                i++;
                
                refereeNames = Arrays.copyOf(refereeNames, refereeNames.length + 1);
                
                refereeNames[i] = rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getInt("referee_id");
                 
            }
            
            rs.close();
            con.close();
            stmnt.close();
            
        } catch (SQLException e){
            
            System.out.println(e.getMessage());
            
        }
        
        return refereeNames;
        
    }
    /**
     * Updates the selected referee.
     * @param refereeName
     * @param r 
     */
    public void updateReferee(String refereeName, Referee r){

        int refereeID = getRefereeID(refereeName);
        
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.REFEREE WHERE referee_id = " + refereeID;
            rs = stmnt.executeQuery(SQL);
            
            rs.next();
            
            rs.updateString("address", r.getAddress());
            rs.updateDate("date_of_birth", r.getDateOfBirth());
            rs.updateString("telephone_number", r.getTelephoneNumber());

            rs.updateRow();
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    /**
     * Deletes the currently selected referee.
     * @param refereeName 
     */
    public void deleteReferee(String refereeName){
        
        int refereeID = getRefereeID(refereeName);
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.REFEREE WHERE referee_id = " + refereeID;
            rs = stmnt.executeQuery(SQL);
            
            rs.next();

            rs.deleteRow();
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    
    }
    /**
     * Gets the referee ID from the given referee name.
     * @param refereeName
     * @return 
     */
    public int getRefereeID(String refereeName){
        
        int i = 0, blank = 0, refereeID = 0;
        
        while(true){
            
            if(refereeName.substring(i, i + 1).equals(" ")){
                
                blank++;
                
                if(blank == 2){
                    
                    refereeID = Integer.parseInt(refereeName.substring(i + 1));
                    
                    break;
                    
                }
            }
            
            i++;
            
        }
        
        return refereeID;
        
    }
    
}

}
