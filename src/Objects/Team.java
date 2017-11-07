/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author joshf
 */
public class Team {
    
    private String teamName;
    private String teamCaptain;
    
    public void Team(String teamName, String teamCaptain){
        
        this.teamName = teamName;
        this.teamCaptain = teamCaptain;
        
    }
    
    public String getTeamName(){
        
        return teamName;
        
    }
    
    public String getTeamCaptain(){
        
        return teamCaptain;
        
    }
    
}
