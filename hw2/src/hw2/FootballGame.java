package hw2;

/**
 * 
 * @author Andrew Hancock
 *
 */

public class FootballGame {
	
	/**
	 * extra point value
	 */
	public static final int EXTRA_POINTS = 1;
	/**
	 * field goal point value
	 */
	public static final int FIELD_GOAL_POINTS = 3;
	/**
	 * length of field in yards
	 */
	public static final int FIELD_LENGTH = 100;
	/**
	 * starting position of offensive team from goal line
	 */
	public static final int STARTING_POSITION = 70;
	/**
	 * amount of point for a touch down
	 */
	public static final int TOUCHDOWN_POINTS = 6;
	/**
	 * initial yards until a first down unless team is less than 10 yards from goal
	 */
	public static final int YARDS_FOR_FIRST_DOWN = 10;
	
	/**
	 * keeps track of the offensive teams yards to touch down.
	 */
	private int yardsToGoal;
	/**
	 * keeps track of current down.
	 */
	private int down;
	/**
	 * keeps track of the team in control of the ball.
	 */
	private int offensiveTeam;
	/**
	 * keeps track of how much progress has been made on the current set of downs.
	 */
	private int downProgress;
	/**
	 * keeps track of team 0's score
	 */
	private int team0Score;
	/**
	 * keeps track of team 1's score.
	 */
	private int team1Score;
	
	/**
	 * constructor for a new football game with appropriate values set
	 */
	public FootballGame(){
		down = 1;
		yardsToGoal = STARTING_POSITION;
		offensiveTeam = 0;
		downProgress = 10;
		team0Score = 0;
		team1Score = 0;
	}
	
	/**
	 * adds a point to a the offensive team if they successfully made an 
	 * extra point or no point if they were unsuccessful. Afterward resets the 
	 * values for the other team to be the offensive team.
	 * @param true if they made it false if they didn't
	 */
	public void extraPoint(boolean success){
		if(offensiveTeam == 0){
			if(success == true){
				team0Score+=EXTRA_POINTS;
				offensiveTeam = 1;
				yardsToGoal = STARTING_POSITION;
				down = 1;
				downProgress = 10;
			}else{
				offensiveTeam = 1;
				yardsToGoal = STARTING_POSITION;
				down = 1;
				downProgress = 10;
			}
		}
		else if(offensiveTeam == 1){
			if(success == true){
				team1Score+=EXTRA_POINTS;
				offensiveTeam = 0;
				yardsToGoal = STARTING_POSITION;
				down = 1;
				downProgress = 10;
			}else{
				offensiveTeam = 0;
				yardsToGoal = STARTING_POSITION;
				down = 1;
				downProgress = 10;
			}
		}
	}
	
	/**
	 * adds points to an offensive team's score if they made a field goal 
	 * and if they didn't no points added. Also resets ball for the other team 
	 * after the field goal.
	 * @param true if they made it, false if they didn't
	 */
	public void fieldGoal(boolean success){
		if(offensiveTeam == 0){
			if(success == true){
				team0Score+=FIELD_GOAL_POINTS;
				offensiveTeam = 1;
				down = 1;
				downProgress = 10;
				yardsToGoal = STARTING_POSITION;
			}else{
				offensiveTeam = 1;
				down = 1;
				yardsToGoal = 100 - yardsToGoal;
				if(yardsToGoal < 10){
					downProgress = yardsToGoal;
				}else{
					downProgress = 10;
				}
			}
		}
		else if(offensiveTeam == 1){
			if(success == true){
				team1Score+=FIELD_GOAL_POINTS;
				offensiveTeam = 0;
				down = 1;
				downProgress = 10;
				yardsToGoal = STARTING_POSITION;
			}else{
				offensiveTeam = 0;
				down = 1;
				yardsToGoal = 100 - yardsToGoal;
				if(yardsToGoal < 10){
					downProgress = yardsToGoal;
				}else{
					downProgress = 10;
				}
			}
		}
	}
	
	/**
	 * returns the current down
	 * @return current down
	 */
	public int getDown(){
		return down;
	}
	
	/**
	 * returns index of current offensive team
	 * @return current offensive team.
	 */
	public int getOffense(){
		return offensiveTeam;
	}
	
	/**
	 * returns the score of the team sent to the function
	 * @param index of which team's score the program wants
	 * @return score of which team
	 */
	public int getScore(int whichTeam){
		if(whichTeam == 0){
			return team0Score;
		}else{
			return team1Score;
		}
	}
	
	/**
	 * gets the yards until a first down
	 * @return yards until offensive team gets a first down
	 */
	public int getYardsToFirstDown(){
		return downProgress;
	}
	
	/**
	 * gets yards until offensive team reaches goal line
	 * @return yards until current offensive team reaches goal line
	 */
	public int getYardsToGoalLine(){
		return yardsToGoal;
	}
	
	/**
	 * offensive team punts and the other team becomes the offensive team
	 * at the spot of where the punt landed or the 100 yards; whichever is the minimum.
	 * @param length of punt
	 */
	public void punt(int yards){
		if(offensiveTeam == 1){
			offensiveTeam = 0;
		}else{
			offensiveTeam = 1;
		}
		yardsToGoal = Math.min(100, (100 - (yardsToGoal - yards)));
	}
	
	/**
	 * offensive team either runs or passes the ball a certain number of yards. This
	 * function decides whether the offensive gets a touch down, has to turn over the
	 * ball, or just goes up a down. If they get a touch down then the points get added 
	 * and the game gets set for the other team to play offense at the correct position.
	 * If there is a turnover then the other team is the offensive team at the spot of the 
	 * turnover.
	 * @param length of run of pass
	 */
	public void runOrPass(int yards){
		
		//deals with the case of a touch down
		
		if((yardsToGoal - yards) <= 0){
			if(offensiveTeam == 0){
				team0Score+=6;
				yardsToGoal = 70;
				down = 1;
				downProgress = 10;
			}else{
				team1Score+=6;
				yardsToGoal = 70;
				down = 1;
				downProgress = 10;
			}
			
		}
		
		//deals with turnovers
		
		else if(((downProgress - yards) >= 1) && (down == 4)){
			if(offensiveTeam == 1){
				offensiveTeam = 0;
				yardsToGoal = 100 - yardsToGoal;
				down = 1;
				downProgress = 10;
			}else{
				offensiveTeam = 1;
				yardsToGoal = 100 - yardsToGoal;
				down = 1;
				downProgress = 10;
			}
		}
		
		//deals with normal run or pass(non touch down or turnover) also non first down
		 
		else if(((downProgress - yards) >= 1) && (down < 4)){
			yardsToGoal = Math.min(100, yardsToGoal - yards); 
			down++;
			downProgress = downProgress - yards;
		}
		
		//deals with first downs 
		
		else if(((downProgress - yards) <= 0) && (down < 5)){
			down = 1;
			if(yardsToGoal < 10){
				downProgress = yardsToGoal;
			}else{
				downProgress = 10;
			}
			
			yardsToGoal = yardsToGoal - yards;
			
		}
	}
	
}
