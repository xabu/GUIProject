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
	/**
	 * 
	 */
	public Question(){
		super();
		label = new JLabel("Default Question");
		for(int i = 0; i < answers.length;i++){
			answers[i] = new Answer(i-1);
			group.add(answers[i]);
		}
	}
	/**
	 * 
	 * @param text
	 */
	public Question(String text){
		super();
		String[] params = text.split('#');
		question = params[0];
		label = new JLabel(question);
		for(int i = 0; i < answers.length;i++){
			answers[i] = new Answer(params[i+1], i-1);
			group.add(answers[i]);
		}
	}
	public Answer[] getAnswers(){
		return answers;
	}
	public JButton getConfirm(){
		return confirm;
	}
	public JLabel getLabel(){
		return label;
	}
	public void addListeners(ActionListener a){
		confirm.addActionListener(a);
	}
	
}
