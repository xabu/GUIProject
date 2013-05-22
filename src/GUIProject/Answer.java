package GUIProject;

import javax.swing.JRadioButton;
/**
 * An object that describes a possible answer to each of the women's questions.
 * @author Stephen Wen
 *
 */
public class Answer extends JRadioButton {
	private String option;
	private int points;
	/**
	 * Creates an Answer object that is represented by the string, worth no points
	 * @param text the String that represents what the player will say
	 */
	public Answer(String text){
		super();
		option = text;
		setText(option);
		points = 0;
	}
	/**
	 * Creates an Answer object that is represented by text, and gives a point value.
	 * @param text the String that represents what the player will say
	 * @param p the amount of points awarded by selecting this option
	 */
	public Answer(String text, int p){
		super();
		option = text;
		setText(option);
		points = p;
	}
	/**
	 * Returns the number of points that should be added to the score of the player by selecting this answer
	 * @return
	 */
	public int getPoints(){
		return points;
	}
}
