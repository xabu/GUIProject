package GUIProject;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Answer extends JButton implements ActionListener {
	String option;
	int points;
	/**
	 * default constructor
	 */
	public Answer(){
		super();
		option = "Default Answer";
		setText(option);
		addActionListener(this);
	}
	
	public Answer(String text){
		super();
		option = text;
		setText(option);
		addActionListener(this);
	}
	/**
	 * 
	 * @return
	 */
	public int getPoints(){
		return points;
	}
	
	
	public void actionPerformed(ActionEvent e){
	}
}
