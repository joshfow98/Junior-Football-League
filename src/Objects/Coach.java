/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;
import java.sql.Date;
/**
 * Stores/returns details about a team coach.
 * @author joshf
 */
public class Coach extends Person{
    
    private String team;
    /**
     * Stores the details for the instance of the coach class.
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     * @param telephoneNumber
     * @param team 
     */
    public void Coach(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String team){
        
        super.Person(firstName, lastName, address, dateOfBirth, telephoneNumber);
        
        this.team = team;
        
    }
    /**
     * Returns the team the coach coaches.
     * @return 
     */
    public String getTeam(){
        
        return team;
        
    }
    
}
