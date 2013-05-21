package GUIProject;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
	private BufferedImage Face, goodEnd, okayEnd, badEnd;
	private String phoneNumber, name;
	private Question currentQuestion;
	private Location myLoc;
	int counter = 0;
	/*
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
		
	}*/
	public Person(String str, Location loc){
		super();
		myLoc = loc;
		setLayout(new BorderLayout());
		String[] params = str.split(",");
		questionMax = Integer.parseInt(params[0]);
		currentPoints = Integer.parseInt(params[1]);
		name = params[2];          
		Face = loadImage(name);
		goodEnd = loadImage(name+"Happy");
		badEnd = loadImage(name+"Mad");
		okayEnd = loadImage(name+"Neutral");
		words = new Question[3][2];
		for(int i = 0; i < words.length*words[0].length;i++){
			words[i%3][i/3] = new Question(params[i+3], this);
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
	public Location getLoc(){
		return myLoc;
	}
	/**
	 * 
	 */
	public void end(){
		removeAll();
		EndDialog endDialog = new EndDialog(name, currentPoints/3, phoneNumber, this);
		
		/*
		JDialog endDialog = new JDialog();
		JLabel endLabel = new JLabel();
		badEnd = loadImage(name+"Mad");
		goodEnd = loadImage(name+"Happy");
		okayEnd = loadImage(name+"Neutral");
		if(currentPoints<=words.length/3){
			endLabel.setText("I am never talking to you again");
		}
		else if (currentPoints<=2*words.length/3){
			endLabel.setText("Maybe we'll talk again sometime");
		}
		else{
			endLabel.setText("Here is my #" + phoneNumber);
		}
		endDialog.add(endLabel);
		endDialog.pack();
		endDialog.setVisible(true);*/
		repaint();
	}
	public String getName(){
		return name;
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
	private static BufferedImage loadImage(String filename){
		BufferedImage image = null;
		String filePath = "src\\GUIProject\\otherFiles\\"+filename+".jpg";
		try {                
			image = ImageIO.read(new File(filePath));
	    } catch (IOException ex) {
	        System.out.println("Couldn't find the file at "+filePath);
	    }
		return image;
	}
}
