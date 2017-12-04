/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Objects.Coach;
/**
 *
 * @author joshf
 */
public class CoachEngine {
    
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    
    public Coach getCoach(String teamName){
        
        Coach c = new Coach();
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.COACH WHERE team_name = '" + teamName + "'";
            rs = stmnt.executeQuery(SQL);
            rs.next();
            
            c.Coach(rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), 
                    rs.getDate("date_of_birth"), rs.getString("telephone_number"), rs.getString("team_name"));

            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return c;
        
    }
    
    public void updateCoach(Coach c){
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.COACH WHERE team_name = '" + c.getTeam() + "'";
            rs = stmnt.executeQuery(SQL);
            rs.next();
            
            rs.updateString("first_name", c.getFirstName());
            rs.updateString("last_name", c.getLastName());
            rs.updateString("address", c.getAddress());
            rs.updateDate("date_of_birth", c.getDateOfBirth());
            rs.updateString("telephone_number", c.getTelephoneNumber());

            rs.updateRow();
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
    public void deleteCoach(String team){
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM JFL.COACH WHERE team_name = '" + team + "'";
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
