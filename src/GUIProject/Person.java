package GUIProject;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
 * This class describes a person who can be approached in the game.
 * @author Stephen Wen
 *
 */
public class Person extends JPanel implements ActionListener{
	private Question[][] words;
	private int currentPoints,questionMax, quesNum = 0, initPoints;
	private Image Face;
	private String phoneNumber, name;
	private Question currentQuestion;
	private Location myLoc;
	private JLabel imageLabel;
	private JPanel image;

	/**
	 * Creates a person using a String, and the location to which this person object belongs.
	 * @param str a formatted String to be used to define all variables
	 * @param loc the location that this person belongs to
	 */
	public Person(String str, Location loc){
		super();
		myLoc = loc;
		setLayout(new BorderLayout());
		String[] params = str.split(",");
		questionMax = Integer.parseInt(params[0]);
		initPoints = Integer.parseInt(params[1]);
		currentPoints = initPoints;
		name = params[2];          
		Face = loadImage(name);
		imageLabel = new JLabel(new ImageIcon(Face));
		words = new Question[3][2];
		for(int i = 0; i < words.length*words[0].length;i++){
			words[i%3][i/3] = new Question(params[i+3], this);
		}
		phoneNumber = params[params.length-1];
		currentQuestion = words[currentPoints][(int)(Math.random()*words[0].length)];
		image = new JPanel();
		image.setLayout(new BorderLayout());
		image.add(imageLabel, BorderLayout.PAGE_START);
		image.add(currentQuestion.getLabel(), BorderLayout.PAGE_END);
		add(image, BorderLayout.PAGE_START);
		add(currentQuestion);
	}
	/**
	 * adds all components of a question to the person JPanel
	 * @param q the question to be added to the person Panel
	 */
	public void add(Question q){
		//image.add(q.getLabel(), BorderLayout.PAGE_END);
		super.add(q.getAnswers()[0],BorderLayout.LINE_START);
		super.add(q.getAnswers()[1],BorderLayout.CENTER);
		super.add(q.getAnswers()[2],BorderLayout.LINE_END);
		super.add(q.getConfirm(), BorderLayout.PAGE_END);
		currentQuestion.addListeners(this);
		validate();
	}
	/**
	 * returns the location that this person belongs to
	 * @return
	 */
	public Location getLoc(){
		return myLoc;
	}
	/**
	 * creates an endDialog object that shows the ending of the date.
	 */
	public void end(){
		//removeAll();
		EndDialog endDialog = new EndDialog(name, currentPoints, phoneNumber, this);
		repaint();
	}
	/**
	 * Resets the values of the person object.
	 */
	public void reset(){
		quesNum = 0;
		currentPoints = initPoints;
	}
	/**
	 * Returns the name of the person
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * Checks which answer has been selected and adds points, changes the question.
	 * @param e a generic ActionEvent
	 */
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
					image.removeAll();
					image.add(imageLabel, BorderLayout.PAGE_START);
					image.add(currentQuestion.getLabel(), BorderLayout.PAGE_END);
					add(image, BorderLayout.PAGE_START);
					add(currentQuestion);
					Main.frame.pack();
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
