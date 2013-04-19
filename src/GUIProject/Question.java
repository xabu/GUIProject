package GUIProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Question {
	public Answer[] answers = new Answer[3];
	public JLabel label;
	public String question;
	/**
	 * 
	 */
	public Question(){
		super();
		label = new JLabel("Default Question");
		for(int i = 0; i < answers.length;i++){
			answers[i] = new Answer();
		}
	}
	public Question(String text){
		super();
		label = new JLabel(text);
		for(int i = 0; i < answers.length;i++){
			answers[i] = new Answer();
		}
	}
	
}
