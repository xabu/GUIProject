package GUIProject;

import java.io.File;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Player {
	private String name;
	private int points;
	private File highScores;
	private Point loc;

	highScores = new File ("src/GUIProject/HighScores.txt");
	
	if (!highScores.exists()){
		highScores.createNewFile();
	}
	
	public Player(){
		
	}
	/**
	 * 
	 */
	public void addScore(){
		highScores
	}
	public Point getLoc(){
		return loc;
	}
}
