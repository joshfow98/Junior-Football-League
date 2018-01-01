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
public class Match {
    
    private String homeTeam;
    private String awayTeam;
    private Date matchDate;
    private int referee;
    private int homeTeamScore;
    private int awayTeamScore;
    private String result;
    /**
     * Sets all the variable values when instance of class is called.
     * @param homeTeam
     * @param awayTeam
     * @param matchDate
     * @param referee
     * @param homeTeamScore
     * @param awayTeamScore
     * @param result 
     */
    public Match(String homeTeam, String awayTeam, Date matchDate, int referee, int homeTeamScore, int awayTeamScore, String result){
        
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.referee = referee;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.result = result;
        
    }

    
    /**
     * Sets variable homeTeam value.
     * @param homeTeam 
     */
    public void setHomeTeam(String homeTeam){
        
        this.homeTeam = homeTeam;
        
    }
    /**
     * Sets variable awayTeam value.
     * @param awayTeam 
     */
    public void setAwayTeam(String awayTeam){
        
        this.awayTeam = awayTeam;
        
    }
    /**
     * Sets variable matchDate value.
     * @param matchDate 
     */
    public void setmatchDate(Date matchDate){
        
        this.matchDate = matchDate;
        
    }
    /**
     * Sets variable referee value.
     * @param referee 
     */
    public void setReferee(int referee){
        
        this.referee = referee;
        
    }
    /**
     * Sets variable homeTeamScore value.
     * @param homeTeamScore 
     */
    public void setHomeTeamScore(int homeTeamScore){
        
        this.homeTeamScore = homeTeamScore;
        
    }
    /**
     * Sets variable awayTeamScore value.
     * @param awayTeamScore 
     */
    public void setAwayTeamScore(int awayTeamScore){
        
        this.awayTeamScore = awayTeamScore;
        
    }
    /**
     * Sets variable result value.
     * @param result 
     */
    public void setResult(String result){
        
        this.result = result;
        
    }
    /**
     * Gets homeTeam value.
     * @return 
     */
    public String getHomeTeam(){
        
        return homeTeam;
        
    }
    /**
     * Gets awayTeam value.
     * @return 
     */
    public String getAwayTeam(){
        
        return awayTeam;
        
    }
    /**
     * Gets matchDate value.
     * @return 
     */
    public Date getMatchDate(){
        
        return matchDate;
        
    }
    /**
     * Gets referee value.
     * @return 
     */
    public int getReferee(){
        
        return referee;
        
    }
    /**
     * Gets homeTeamScore value.
     * @return 
     */
    public int getHomeTeamScore(){
        
        return homeTeamScore;
        
    }
    /**
     * Gets awayTeamScore value.
     * @return 
     */
    public int getAwayTeamScore(){
        
        return awayTeamScore;
        
    }
    /**
     * Gets result value.
     * @return 
     */
    public String getResult(){
        
        return result;
        
    }
    
}
