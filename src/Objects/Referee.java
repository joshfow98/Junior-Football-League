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
public class Referee extends Person{
    
    public void Referee(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber){
        
        super.Person(firstName, lastName, address, dateOfBirth, telephoneNumber);
        
    }
    
}
