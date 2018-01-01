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
    /**
     * Sets the details of an instance of the Person class.
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     * @param telephoneNumber 
     */
    public void Person(String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        
    }
    /**
     * Returns persons first name.
     * @return 
     */
    public String getFirstName(){
        
        return firstName;
        
    }
    /**
     * Returns persons last name.
     * @return 
     */
    public String getLastName(){
        
        return lastName;
        
    }
    /**
     * Returns persons address.
     * @return 
     */
    public String getAddress(){
        
        return address;
        
    }
    /**
     * Returns persons date of birth.
     * @return 
     */
    public Date getDateOfBirth(){
        
        return dateOfBirth;
        
    }
    /**
     * Returns persons telephone number.
     * @return 
     */
    public String getTelephoneNumber(){
        
        return telephoneNumber;
        
    }
    
}
