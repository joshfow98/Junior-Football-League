/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Objects.Manager;
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
public class NewManagerEngine {
    
    /**
     * This adds a new manager to the Manager table in the JFL DB.
     * @param c 
     */
    public void createNewManager(Manager m){
        
        
        Connection con;
        Statement stmnt;
        ResultSet rs;
        String SQL;
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.MANAGER";
            
            rs = stmnt.executeQuery(SQL);
            
            int i = 0;
            while(rs.next()){
                
                if(rs.getString("team_name").equals(m.getTeam())){
                    
                    throw new InputExceptions("This team already has a manager");
                    
                }
                
                i = rs.getInt("manager_id") + 1;
                
            }
            
            rs.moveToInsertRow();
            
            rs.updateInt("manager_id", i);
            rs.updateString("first_name", m.getFirstName());
            rs.updateString("last_name", m.getLastName());
            rs.updateString("address", m.getAddress());
            rs.updateDate("date_of_birth", (Date) m.getDateOfBirth());
            rs.updateString("telephone_number", m.getTelephoneNumber());
            rs.updateString("team_name", m.getTeam());
            
            rs.insertRow();
            
            rs.close();
            con.close();
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    
    
}
