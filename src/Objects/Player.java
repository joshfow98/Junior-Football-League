/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;
import java.sql.Date;
/**
 * Stores/returns details about a player.
 * @author joshf
 */
public class Player extends Coach{
    
    private String position;
    private int playerID;
    /**
     * Stores details for an instance of the Player class.
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     * @param telephoneNumber
     * @param team
     * @param position 
     */
    public void Player(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String team, String position){
        
        super.Coach(firstName, lastName, address, dateOfBirth, telephoneNumber, team);
        
        this.position = position;
        
    }
    /**
     * Returns the players position.
     * @return 
     */
    public String getPosition(){
        
        return position;
        
    }
    /**
     * Sets the players ID.
     * @param playerID 
     */
    public void setPlayerID(int playerID){
        
        this.playerID = playerID;
        
    }
    /**
     * Returns the players ID.
     * @return 
     */
    public int getPlayerID(){
        
        return  playerID;
        
    }
    
}
