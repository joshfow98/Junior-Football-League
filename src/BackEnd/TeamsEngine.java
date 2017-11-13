/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Objects.Team;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * This class connects to the JFL database and the methods help to
 * retrieve, store, update and delete records in the Team table.
 * @author joshf
 */
public class TeamsEngine {
    
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    /**
     * This connects to the JFL database and stores the records
     * from the Team table into a ResultSet
     */
    public void getConnection(){
        
        try{
            
            String host = "jdbc:derby://localhost:1527/JFL", uName = "JFL", uPass = "JFL";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            SQL = "SELECT * FROM JFL.TEAM";
            
            rs = stmnt.executeQuery(SQL);
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    /**
     * Returns the team names from the database.
     * @return 
     */
    public String[] getTeamNames(){
        
        String[] team = new String[0];
        int i = 0;
        
        try{
            
           getConnection();
            
            while(rs.next()){
                
                team = Arrays.copyOf(team, team.length + 1);
                
                team[i] = rs.getString("team_name");
                
                i++;
                        
            }
            
            rs.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return team;
        
    }
    /**
     * Retrieves the team captain for the chosen team.
     * @param teamName
     * @return 
     */
    public Team getTeamDetails(String teamName){
        
        Team team = new Team();
        
        try{
            
           getConnection();
            
            while(rs.next()){
                
                if(rs.getString("team_name").equals(teamName)){
                    
                    team.Team(rs.getString("team_name"), rs.getString("captain"));
                    break;
                    
                }
                        
            }
            
            rs.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return team;
        
    }
    /**
     * This sets the new team captain and stores it in the database.
     * @param team 
     */
    public void setTeam(Team team){
        
        try{
           
            if(team.getTeamCaptain().equals("")){
                
                throw new InputExceptions("There must be a captain");
                
            }
            
            getConnection();
            
                while(rs.next()){
                
                   if(rs.getString("team_name").equals(team.getTeamName())){
                    
                        break;
                    
                    }
                        
                 }
                
            rs.updateString("captain", team.getTeamCaptain());
            rs.updateRow();
            
            System.out.println(rs.getString("captain"));
            rs.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        } catch (InputExceptions e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    /**
     * This deletes the chosen team from the database
     * @param team 
     */
    public void deleteTeam(Team team){
        
        try{
            
            getConnection();
           
            
            while(rs.next()){
                
                if(rs.getString("team_name").equals(team.getTeamName())){
                    
                    rs.deleteRow();
                    break;
                    
                }
                        
            }
            
            
            System.out.println(rs.getString("captain"));
            rs.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
}
