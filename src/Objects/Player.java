/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;
import java.sql.Date;
/**
 *
 * @author joshf
 */
public class Player extends Coach{
    
    private String position;
    private int playerID;
    
    public void Player(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String team, String position){
        
        super.Coach(firstName, lastName, address, dateOfBirth, telephoneNumber, team);
        
        this.position = position;
        
    }
    
    public String getPosition(){
        
        return position;
        
    }
    
    public void setPlayerID(int playerID){
        
        this.playerID = playerID;
        
    }
    
    public int getPlayerID(){
        
        return  playerID;
        
    }
    
}
