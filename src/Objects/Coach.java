/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;
import java.util.Date;
/**
 *
 * @author joshf
 */
public class Coach extends Person{
    
    private String team;
    
    public void Coach(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String team){
        
        super.Person(firstName, lastName, address, dateOfBirth, telephoneNumber);
        
        this.team = team;
        
    }
    
}
