/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * Stores/returns details about a team.
 * @author joshf
 */
public class Team {
    
    private String teamName;
    private String teamCaptain;
    private int points = 0;
    private int goals = 0;
    /**
     * Sets the team name and the team captain when instance of class is declared.
     * @param teamName
     * @param teamCaptain 
     */
    public void Team(String teamName, String teamCaptain){
        
        this.teamName = teamName;
        this.teamCaptain = teamCaptain;
        
    }
    /**
     * Sets number of points the team has.
     * @param points 
     */
    public void setPoints(int points){
        
        this.points = points;
        
    }
    /**
     * Sets the number of goals the team has scored.
     * @param goals 
     */
    public void setGoals(int goals){
        
        this.goals = goals;
        
    }
    /**
     * Returns the number of points the team has.
     * @return 
     */
    public int getPoints(){
        
        return points;
        
    }
    /**
     * Returns the number of goals the team has scored.
     * @return 
     */
    public int getGoals(){
        
        return goals;
        
    }
    /**
     * Sets the team name.
     * @param teamName 
     */
    public void setTeamName(String teamName){
        
        this.teamName = teamName;
        
    }
    /**
     * Sets the team captain.
     * @param teamCaptain 
     */
    public void setTeamCaptain(String teamCaptain){
        
        this.teamCaptain = teamCaptain;
        
    }
    /**
     * Returns the teams name.
     * @return 
     */
    public String getTeamName(){
        
        return teamName;
        
    }
    /**
     * Returns the team captain.
     * @return 
     */
    public String getTeamCaptain(){
        
        return teamCaptain;
        
    }
    
}
