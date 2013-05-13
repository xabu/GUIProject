package GUIProject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.awt.Point;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Player {
	private String name;
	private int points, score, placemark;
	private File highScores;
	private Point loc;
	private String[] content;
	private BufferedReader br;
	public Player(){
		highScores = new File ("src/GUIProject/HighScores.txt");
		try{
			br = new BufferedReader (new FileReader ("src/GUIProject/HighScores.txt"));
		}
		catch(IOException e){
			System.out.println("There is no such file");
		}
		if (!highScores.exists()){
			try{
				highScores.createNewFile();
			}
			catch(IOException e){
				System.out.println("There is no file");
			}
		}
		}
	/**
	 * 
	 */
	public void readScore(){
		String currentLine;
		boolean noChanges = true;
		int counter = 0, rank = 0;
		
		try {
			while((currentLine = br.readLine()) != null){
				content[counter] = currentLine;
				counter++;
				
				noChanges = compareScore(currentLine);
				if (noChanges == true)rank++;
			}
		} catch (IOException e) {
			System.out.println("There is no file");
		}
		
		if (noChanges == false){
			addScore (rank);
		}
	} 
	public boolean compareScore(String line){
		String numText, error;
		
		error = "File contents invalid.";
		placemark = line.indexOf ('/');
		numText = line.substring (0, placemark);
		
		try{
			score = Integer.parseInt (numText);
		}
		catch (NumberFormatException e){
			System.out.println (error);
		}
		
		if (points > score){
			return false;
		}
		else {
			return true;
		}
	}
	public void addScore(int rank){
		String lineRank;
		
		content[rank] = points + "/" + name;
		
		FileWriter fw;
		try {
			fw = new FileWriter(highScores.getAbsoluteFile());
		} catch (IOException e) {
			fw = null;
		}
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (int i = 0; i < content.length; i++){
			lineRank = content[i];
			try {
				bw.write(lineRank);
				bw.newLine();
			} catch (IOException e) {
				
			}
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			
		}
	}	
	public void moveUp(){
		loc.translate(0,-20);
	}
	public void moveDown(){
		loc.translate(0, 20);
	}
	public void moveRight(){
		loc.translate(20, 0);
	}
	public void moveLeft(){
		loc.translate(-20,0);
	}
	public Point getLoc(){
		return loc;
	}
}
