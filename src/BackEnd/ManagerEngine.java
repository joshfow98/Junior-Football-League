/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Objects.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author joshf
 */
public class ManagerEngine {
    
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    
    /**
     * returns the manager for the selected team.
     * @param teamName
     * @return 
     */
    public Manager getManager(String teamName){
        
        Manager m = new Manager();
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.MANAGER WHERE team_name = '" + teamName + "'";
            rs = stmnt.executeQuery(SQL);
            
            if(rs.next() == false){
                
                throw new NoPersonException("There is no manager for this team");
                
            }
            
            
            m.Coach(rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), 
                    rs.getDate("date_of_birth"), rs.getString("telephone_number"), rs.getString("team_name"));

            rs.close();
            stmnt.close();
            con.close();
            
        } catch (NoPersonException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return m;
        
    }
    /**
     * Updates the selected managers details.
     * @param m 
     */
    public void updateManager(Manager m){
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.MANAGER WHERE team_name = '" + m.getTeam() + "'";
            rs = stmnt.executeQuery(SQL);
            rs.next();
            
            rs.updateString("first_name", m.getFirstName());
            rs.updateString("last_name", m.getLastName());
            rs.updateString("address", m.getAddress());
            rs.updateDate("date_of_birth", m.getDateOfBirth());
            rs.updateString("telephone_number", m.getTelephoneNumber());

            rs.updateRow();
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    /**
     * Deletes the currently selected manager.
     * @param team 
     */
    public void deleteManager(String team){
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.MANAGER WHERE team_name = '" + team + "'";
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
    
}
