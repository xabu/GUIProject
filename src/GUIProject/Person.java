package GUIProject;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Person extends JPanel implements ActionListener{
	private Question[][] words;
	private int currentPoints,questionMax, quesNum = 0;
	private Image Face;
	private String phoneNumber, name;
	private Question currentQuestion;
	/**
	 * 
	 */
	public Person(){
		super();
		questionMax = 5;
		setLayout(new BorderLayout());
		words = new Question[3][2];
		currentPoints = (int)(Math.random()*words.length);
		for(int i = 0; i<words.length;i++){
			for(int j = 0; j<words[0].length;j++){
				words[i][j] = new Question("This is the "+ j + "th "+ i + " point question ");
			}
		}
		currentQuestion = words[currentPoints][(int)(Math.random()*words[0].length)];
		add(currentQuestion);
		
	}
	public Person(String str){
		super();
		setLayout(new BorderLayout());
		String[] params = str.split(',');
		questionMax = Integer.parseInt(params[0]);
		currentPoints = Integer.parseInt(params[1]);
		name = params[2];
		try {                
	    	   face = ImageIO.read(new File("src/GUIProject/"+name+".jpg"));
	       } catch (IOException ex) {
	    	   System.out.println("Couldn't find the file");
	       }
		words = new Question[3][2];
		for(int i = 0; i < words.length;i++){
			words[i%3][i/3] = new Question(params[i+3]);
		}
		currentQuestion = words[currentPoints][(int)(Math.random()*words[0].length)];
		add(currentQuestion);
	}
	/**
	 * 
	 * @param q
	 */
	public void add(Question q){
		super.add(q.getLabel(), BorderLayout.PAGE_START);
		super.add(q.getAnswers()[0],BorderLayout.LINE_START);
		super.add(q.getAnswers()[1],BorderLayout.CENTER);
		super.add(q.getAnswers()[2],BorderLayout.LINE_END);
		super.add(q.getConfirm(), BorderLayout.PAGE_END);
		currentQuestion.addListeners(this);
		validate();
	}
	/**
	 * 
	 */
	public void end(){
		System.out.println("Ended the date");
		removeAll();
		JLabel endLabel = new JLabel();
		if(currentPoints<=4){
			endLabel.setText("I SLAP YOU BITCH");
		}
		else if (currentPoints<=7){
			endLabel.setText("Maybe we'll talk again sometime");
		}
		else{
			endLabel.setText("Here is my #");
		}
		add(endLabel);
	}
	public void actionPerformed(ActionEvent e){
		quesNum++;
		if(currentPoints>=0 && currentPoints<=words.length-1&&quesNum<=questionMax){
			for(int i = 0; i < currentQuestion.getAnswers().length;i++){
				if(currentQuestion.getAnswers()[i].isSelected()){
					removeAll();
					currentPoints+=currentQuestion.getAnswers()[i].getPoints();
					currentQuestion = words[currentPoints][(int)(Math.random()*words[0].length)];
					add(currentQuestion);
				}
			}
		}
		else{
			end();
		}
	}
}
