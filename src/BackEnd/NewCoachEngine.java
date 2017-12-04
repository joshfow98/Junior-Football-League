/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Objects.Coach;
import Objects.Player;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author joshf
 */
public class NewCoachEngine {
    
    /**
     * This adds a new coach to the Coach table in the JFL DB.
     * @param c 
     */
    public void createNewCoach(Coach c){
        
        
        Connection con;
        Statement stmnt;
        ResultSet rs;
        String SQL;
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.COACH";
            
            rs = stmnt.executeQuery(SQL);
            
            int i = 0;
            while(rs.next()){
                
                if(rs.getString("team_name").equals(c.getTeam())){
                    
                    throw new InputExceptions("This team already has a coach");
                    
                }
                
                i = rs.getInt("coach_id") + 1;
                
            }
            
            rs.moveToInsertRow();
            
            rs.updateInt("coach_id", i);
            rs.updateString("first_name", c.getFirstName());
            rs.updateString("last_name", c.getLastName());
            rs.updateString("address", c.getAddress());
            rs.updateDate("date_of_birth", (Date) c.getDateOfBirth());
            rs.updateString("telephone_number", c.getTelephoneNumber());
            rs.updateString("team_name", c.getTeam());
            
            rs.insertRow();
            
            rs.close();
            con.close();
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    
    
}
