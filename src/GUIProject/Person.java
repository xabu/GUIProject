package GUIProject;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
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
		setLayout(new BorderLayout());
		words = new Question[1][1];
		/*pointMin = 0;
		pointMax = words.length-1;
		currentPoint = (int)(Math.random()*words.length);*/
		for(int i = 0; i<words.length;i++){
			for(int j = 0; j<words[0].length;j++){
				words[i][j] = new Question("This is the "+ j+"th "+ i + " point question ");
			}
		}
		add(words[currentPoint][(int)(Math.random()*words[0].length)]);
	}
	
	/**
	 * 
	 * @param q
	 */
	public void add(Question q){
		super.add(q.label, BorderLayout.PAGE_START);
		/*for(int i = 0; i < q.answers.length; i++){
			super.add(q.answers[i]);
		}*/
		super.add(q.answers[0],BorderLayout.LINE_START);
		super.add(q.answers[1],BorderLayout.CENTER);
		super.add(q.answers[2],BorderLayout.LINE_END);
		validate();
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
