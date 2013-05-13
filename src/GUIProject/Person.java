package GUIProject;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Person extends JPanel implements ActionListener{
	private Question[][] words;
	private int currentPoints,questionMax, quesNum = 0;
	private Image Face, goodEnd, okayEnd, badEnd;
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
				words[i][j] = new Question();
			}
		}
		currentQuestion = words[currentPoints][(int)(Math.random()*words[0].length)];
		add(currentQuestion);
		
	}
	public Person(String str){
		super();
		setLayout(new BorderLayout());
		String[] params = str.split(",");
		questionMax = Integer.parseInt(params[0]);
		currentPoints = Integer.parseInt(params[1]);
		name = params[2];
		System.out.println(name);
		try {                
			Face = ImageIO.read(new File("src/GUIProject/"+name+".jpg"));
		} catch (IOException ex) {
			System.out.println("Couldn't find the file");
		}
		words = new Question[3][2];
		for(int i = 0; i < words.length*words[0].length;i++){
			words[i%3][i/3] = new Question(params[i+3]);
		}
		phoneNumber = params[params.length-1];
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
		try {                
    	   		badEnd = ImageIO.read(new File("src/GUIProject/badEnd"+name+".jpg"));
       		} 
       		catch (IOException ex) {
    	   		System.out.println("Couldn't find the file");
       		}
       		
       		try {                
    	   		okayEnd = ImageIO.read(new File("src/GUIProject/okayEnd"+name+".jpg"));
       		} 
       		catch (IOException ex) {
    	   		System.out.println("Couldn't find the file");
       		}
       		try {                
    	   		goodEnd = ImageIO.read(new File("src/GUIProject/goodEnd"+name+".jpg"));
       		} 
       		catch (IOException ex) {
    	   		System.out.println("Couldn't find the file");
       		}
		if(currentPoints<=4){
			endLabel.setText("I SLAP YOU BITCH");
			//g.drawImage (badEnd, 0, 0, null);
		}
		else if (currentPoints<=7){
			endLabel.setText("Maybe we'll talk again sometime");
			//g.drawImage (okayEnd, 0, 0, null);
		}
		else{
			endLabel.setText("Here is my #" + phoneNumber);
			//g.drawImage (goodEnd, 0, 0, null);
		}
		add(endLabel, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e){
		quesNum++;
		for(int i = 0; i < currentQuestion.getAnswers().length;i++)
			if(currentQuestion.getAnswers()[i].isSelected())
				currentPoints+=currentQuestion.getAnswers()[i].getPoints();
		if(currentPoints>=0 && currentPoints<=words.length-1&&quesNum<=questionMax){
			for(int i = 0; i < currentQuestion.getAnswers().length;i++){
				if(currentQuestion.getAnswers()[i].isSelected()){
					removeAll();
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
