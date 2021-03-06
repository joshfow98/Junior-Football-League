/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objects.Match;
import java.sql.Date;
import UI.Home.InputExceptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * UI to create match records.
 * @author joshf
 */
public class NewMatch extends javax.swing.JFrame {

    /**
     * Creates new form NewPlayer
     */
    public NewMatch() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAddMatch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cbHomeTeam = new javax.swing.JComboBox<>();
        cbAwayTeam = new javax.swing.JComboBox<>();
        cbReferee = new javax.swing.JComboBox<>();
        tfDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Home Team:");

        jLabel2.setText("Date (yyyy-mm-dd):");

        jLabel3.setText("Referee:");

        jLabel7.setText("Away Team:");

        btnAddMatch.setText("Add Match");
        btnAddMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMatchActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");

        btnExit.setText("Exit");
        btnExit.setToolTipText("");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbHomeTeam, 0, 185, Short.MAX_VALUE)
                                        .addComponent(cbAwayTeam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddMatch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cbReferee, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHomeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMatch))
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(cbAwayTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbReferee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMatchActionPerformed
        
        try{
            
            if(String.valueOf(cbAwayTeam.getSelectedItem()).equals(String.valueOf(cbHomeTeam.getSelectedItem()))){
            
                throw new InputExceptions("Two different teams must play each other");
                
            }else if (tfDate.getText().equals("")){
                
                throw new InputExceptions("The match must have a date");
                
            }
            
            NewMatchEngine nme = new NewMatchEngine();
            UI.Referees.RefereeEngine re = new UI.Referees.RefereeEngine();
            
            Match m = new Match(String.valueOf(cbHomeTeam.getSelectedItem()), String.valueOf(cbAwayTeam.getSelectedItem()), 
                                Date.valueOf(String.valueOf(tfDate.getText())), re.getRefereeID(String.valueOf(cbReferee.getSelectedItem())), 0, 0, "");
        
        
            nme.createNewMatch(m);
        
        tfDate.setText("");
        } catch (InputExceptions e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        } catch (IllegalArgumentException e){
            
            JOptionPane.showMessageDialog(null, "The date is incorrect");
            
        }
    }//GEN-LAST:event_btnAddMatchActionPerformed

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
            java.util.logging.Logger.getLogger(NewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMatch().setVisible(true);
                setTeamNames();
                setRefereeNames();
            }
        });
    }
    /**
     * Adds all the team names to the combo box.
     */
    public static void setTeamNames(){
        
        UI.Teams.TeamsEngine te = new UI.Teams.TeamsEngine();
        
        String[] team = te.getTeamNames();
        
        for(int i = 0; i < team.length; i++){
            
           cbHomeTeam.addItem(team[i]);
           cbAwayTeam.addItem(team[i]);
            
        }
        
        
    }
    /**
     * Adds all the referees to the combo box.
     */
    public static void setRefereeNames(){
        
        UI.Referees.RefereeEngine re = new UI.Referees.RefereeEngine();
        
        String[] referee = re.getRefereeNames();
        
        for(int i = 0; i < referee.length; i++){
            
            cbReferee.addItem(referee[i]);
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMatch;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private static javax.swing.JComboBox<String> cbAwayTeam;
    private static javax.swing.JComboBox<String> cbHomeTeam;
    private static javax.swing.JComboBox<String> cbReferee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfDate;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates a new match record.
     */
protected static class NewMatchEngine {
    /**
     * Creates a new match and stores it in the MATCHES table in the DB.
     * @param m 
     */
    public void createNewMatch(Match m){
        
        Connection con;
        Statement stmnt;
        ResultSet rs;
        String SQL;
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.MATCHES";
            
            rs = stmnt.executeQuery(SQL);
            
            int i = 0;
            while(rs.next()){
               
               i = rs.getInt("match_id") + 1; 
                
            }
            
            rs.moveToInsertRow();
            
            rs.updateInt("match_id", i);
            rs.updateString("home_team", m.getHomeTeam());
            rs.updateString("away_team", m.getAwayTeam());
            rs.updateInt("referee_id", m.getReferee());
            rs.updateDate("match_date", m.getMatchDate());
            rs.updateInt("away_team_score", m.getAwayTeamScore());
            rs.updateInt("home_team_score", m.getHomeTeamScore());
            rs.updateString("result", m.getResult());
            
            rs.insertRow();
            
            rs.close();
            con.close();
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
}

}
