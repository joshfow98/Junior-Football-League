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
import java.util.Arrays;
import Objects.Player;
import javax.swing.JOptionPane;
/**
 * This class allows the retrieval of players for certain teams,
 * the updating of player details and finally the deletion of 
 * player details.
 * @author joshf
 */
public class PlayerEngine {
    
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    
    /**
     * This method connects to the Player table in the JFL
     * DB and retrieves all the players and stores them in 
     * a ResultSet.
     */
    public void getConnection(){
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.PLAYER";
            
            rs = stmnt.executeQuery(SQL);
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    /**
     * This method retrieves all the names of the players for a particular team.
     * @param teamName
     * @return 
     */
    public String[] getPlayerNames(String teamName){
        
        String[] team = new String[0];
        String tempName;
        int i = 0;
        
        try{
            
           getConnection();
            
            while(rs.next()){
                
                if(rs.getString("team_name").equals(teamName)){
                
                    tempName = rs.getString("first_name") +  " " + rs.getString("last_name") + " " + rs.getInt("player_id");
                
                    team = Arrays.copyOf(team, team.length + 1);
                
                    team[i] = tempName;
                    
                    i++;
                    
                }
                
           
            }
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return team;
        
    }
    /**
     * This method retrieves all the data about a particular player using
     * the player ID from the playerName.
     * @param playerName
     * @return 
     */
    public Player getPlayer(String playerName){
        
        Player p = new Player();
        int i = 0, firstBlank = 0, playerID;
        
        while(true){
            
            if(playerName.substring(i, i + 1).equals(" ")){
                
                firstBlank++;
                
                if(firstBlank == 2){
                    
                    playerID = Integer.parseInt(playerName.substring(i + 1));
                    
                    break;
                    
                }
            }
            
            i++;
            
        }
        
        try{
            
           getConnection();
            
            while(rs.next()){
                
                if(rs.getInt("player_id") == playerID){
                
                    p.Player(rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getDate("date_of_birth"),
                            rs.getString("telephone_number"), rs.getString("team_name"), rs.getString("position"));
                    p.setPlayerID(rs.getInt("player_id"));
                    
                    break;
                    
                }
           
            }
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return p;
        
    }
    /**
     * This method updates the details of the player given in the parameter.
     * @param p 
     */
    public void updatePlayer(Player p){
        
        try{
            
            getConnection();
            
            while(rs.next()){
                
                if(rs.getInt("player_id") == p.getPlayerID()){
                
                    System.out.println(rs.getInt("player_id"));
                    break;
                    
                }
                
            }
            
            rs.updateString("first_name", p.getFirstName());
            rs.updateString("last_name", p.getLastName());
            rs.updateString("address", p.getAddress());
            rs.updateString("telephone_number", p.getTelephoneNumber());
            rs.updateDate("date_of_birth", p.getDateOfBirth());
            rs.updateString("position", p.getPosition());
            
            rs.updateRow();
            
            rs.close();
            stmnt.close();
            con.close();
            
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    /**
     * This method deletes the player that has the same ID as the given parameter.
     * 
     * @param playerID 
     */
    public void deletePlayer(int playerID){
        
        try{
            
            getConnection();
            
            while(rs.next()){
                
                if(rs.getInt("player_id") == playerID){
                    
                    System.out.println(rs.getInt("player_id") + "2");
                    break;
                    
                }
                
                
            }
            
            rs.deleteRow();
                
            rs.close();
            stmnt.close();
            con.close();
                
        }catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
}
