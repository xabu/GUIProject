package GUIProject;

import javax.swing.JRadioButton;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Answer extends JRadioButton {
	private String option;
	private int points;
	/**
	 * default constructor
	 */
	/*
	public Answer(){
		super();
		option = "Default Answer";
		setText(option);
		points = 0;
	}
	public Answer(int p){
		super();
		option = "Default Answer";
		setText(option);
		points = p;
	}*/
	public Answer(String text){
		super();
		option = text;
		setText(option);
		points = 0;
	}
	public Answer(String text, int p){
		super();
		option = text;
		setText(option);
		points = p;
	}
	/**
	 * 
	 * @return
	 */
	public int getPoints(){
		return points;
	}
}
