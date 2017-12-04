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
public class Person {
    
    private String firstName;
    private String lastName;
    private String address;
    private Date dateOfBirth;
    private String telephoneNumber;
    
    public void Person(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        
    }
    
    public String getFirstName(){
        
        return firstName;
        
    }
    
    public String getLastName(){
        
        return lastName;
        
    }
    
    public String getAddress(){
        
        return address;
        
    }
    
    public Date getDateOfBirth(){
        
        return dateOfBirth;
        
    }
    
    public String getTelephoneNumber(){
        
        return telephoneNumber;
        
    }
    
}
