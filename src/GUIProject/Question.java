package GUIProject;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Question{ 
	private Answer[] answers = new Answer[3];
	private JButton confirm = new JButton("Confirm");
	private ButtonGroup group = new ButtonGroup();
	private JLabel label;
	private String question;
	private Person me;
	/**
	 * creates a question object from a formatted text, p is the person who can ask this question
	 * @param text
	 * @param p
	 */
	public Question(String text, Person p){
		super();
		me = p;
		String[] params = text.split("#");
		question = params[0];
		label = new JLabel(me.getName()+": "+question);
		for(int i = 0; i < answers.length;i++){
			answers[i] = new Answer(params[i+1], i-1);
			group.add(answers[i]);
		}
	}
	/**
	 * returns the array of all possible answers to this question
	 * @return Answer[]
	 */
	public Answer[] getAnswers(){
		return answers;
	}
	/**
	 * returns the button that says confirm
	 * @return
	 */
	public JButton getConfirm(){
		return confirm;
	}
	/**
	 * returns the JLabel that has the question written on it
	 * @return
	 */
	public JLabel getLabel(){
		return label;
	}
	/**
	 * returns the string that is the question being asked
	 * @return
	 */
	public String getQuestion(){
		return label.getText();
	}
	/**
	 * adds an ActionListener to the confirm button
	 * @param a
	 */
	public void addListeners(ActionListener a){
		confirm.addActionListener(a);
	}
	
}
