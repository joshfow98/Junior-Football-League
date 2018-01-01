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
public class Manager extends Coach{
    /**
     * Sets the details for the instance of the Manager class.
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     * @param telephoneNumber
     * @param team 
     */
    public void Manager(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String team){
        
        super.Coach(firstName, lastName, address, dateOfBirth, telephoneNumber, team);
        
    }
    
}
