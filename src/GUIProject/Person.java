package GUIProject;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Person extends JPanel {
	Question[][] words;
	int pointMax, pointMin,currentPoint,questionMax;
	Image Face;
	String phoneNumber;
	/**
	 * 
	 */
	public Person(){
		super();
		words = new Question[10][3];
		pointMin = 0;
		pointMax = words.length-1;
		currentPoint = (int)(Math.random()*words.length);
		for(int i = 0; i<words.length;i++){
			for(int j = 0; j<words[0].length;j++){
				words[i][j] = new Question("This is the "+ j+"th "+ i + " point question ");
			}
		}
		add(words[currentPoint][(int)(Math.random()*words[0].length)]);
		this.validate();
	}
	
	/**
	 * 
	 * @param q
	 */
	public void add(Question q){
		super.add(q.label);
		for(int i = 0; i < q.answers.length; i++){
			super.add(q.answers[i]);
		}
	}
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g){
		
	}
	/**
	 * 
	 */
	public void slap(){
		
	}
	/**
	 * 
	 */
	public void giveNumber(){
		
	}
	/**
	 * 
	 */
	public void happyEnding(){
		
	}
	/**
	 * 
	 */
	public void sadEnding(){
		
	}
}
