/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

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
public class NewPlayerEngine {
    
    private Player player;
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    
    /**
     * Adds a new player to the Player table in the JFL DB
     * @param p 
     */
    public void createNewPlayer(Player p){
        
        try{
            
            if(p.getAddress().equals("") || p.getDateOfBirth().equals("") || p.getFirstName().equals("") ||
                    p.getLastName().equals("") || p.getPosition().equals("") || p.getTeam().equals("") ||
                    p.getTelephoneNumber().equals("")){
                
                throw new InputExceptions("You cannot have empty fields");
                
            }
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.PLAYER";
            
            rs = stmnt.executeQuery(SQL);
            
            
            int i = 0, teamPlayers = 0;
            
            while(rs.next()){
                
                i = rs.getInt("player_id") + 1;
                
                if(rs.getString("team_name").equals(p.getTeam())){
                    
                    teamPlayers++;
                    
                }
                if(teamPlayers == 13){
                    
                    throw new InputExceptions("This team is already at capacity");
                    
                }
                
            }
            
            rs.moveToInsertRow();
            
            rs.updateInt("player_id", i);
            rs.updateString("first_name", p.getFirstName());
            rs.updateString("last_name", p.getLastName());
            rs.updateString("address", p.getAddress());
            rs.updateDate("date_of_birth", (Date) p.getDateOfBirth());
            rs.updateString("telephone_number", p.getTelephoneNumber());
            rs.updateString("position", p.getPosition());
            rs.updateString("team_name", p.getTeam());
            
            rs.insertRow();
            
            rs.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        } catch (InputExceptions e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
}
