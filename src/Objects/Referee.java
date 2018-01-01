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
public class Referee extends Person{
    
    private int refereeID;
    /**
     * Sets the Referee's details.
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     * @param telephoneNumber 
     */
    public void Referee(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber){
        
        super.Person(firstName, lastName, address, dateOfBirth, telephoneNumber);
        
    }
    /**
     * Sets the referee ID.
     * @param refereeID 
     */
    public void setRefereeID(int refereeID){
        
        this.refereeID = refereeID;
        
    }
    /**
     * Returns the referee's ID.
     * @return 
     */
    public int getRefereeID(){
        
        return refereeID;
        
    }
    
}
