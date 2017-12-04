/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Objects.Referee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author joshf
 */
public class RefereeEngine {
    
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    
    /**
     * returns the selected referee.
     * @param teamName
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
     * @param team 
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
