/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Objects.Referee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author joshf
 */
public class NewRefereeEngine {
    
    /**
     * This adds a new referee to the Referee table in the JFL DB.
     * @param c 
     */
    public void createNewReferee(Referee r){
        
        Connection con;
        Statement stmnt;
        ResultSet rs;
        String SQL;
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.REFEREE";
            
            rs = stmnt.executeQuery(SQL);
            
            int i = 0;
            while(rs.next()){
                
                i = rs.getInt("referee_id") + 1;
                
            }
            
            rs.moveToInsertRow();
            
            rs.updateInt("referee_id", i);
            rs.updateString("first_name", r.getFirstName());
            rs.updateString("last_name", r.getLastName());
            rs.updateString("address", r.getAddress());
            rs.updateDate("date_of_birth", (Date) r.getDateOfBirth());
            rs.updateString("telephone_number", r.getTelephoneNumber());
            
            rs.insertRow();
            
            rs.close();
            con.close();
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
}
