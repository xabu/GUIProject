package GUIProject;

import java.io.File;
import java.io.IOException;
import java.awt.Point;
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

	
	
	public Player(){
		
	}
	/**
	 * 
	 */
	public void addScore(){
		highScores = new File ("src/GUIProject/HighScores.txt");
	
		if (!highScores.exists()){
			try{
				highScores.createNewFile();
			}
			catch(IOException e){
				System.out.println("There is no file");
			}
		}
		//highScores
	}
	public Point getLoc(){
		return loc;
	}
}
