package GUIProject;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This class defines the end screen of any date
 * @author Stephen Wen
 *
 */
public class EndDialog extends JDialog {
	BufferedImage face;
	JLabel label;
	Person myPerson;
	/**
	 * Creates an EndDialog to show the end of the date
	 * @param name the name of the person with whom you are ending the date
	 * @param happiness an indication of how happy that person is at the end of your date
	 * @param phoneNumber a string that is the phone number, in case the person was happy withyou
	 * @param p the person that this endDialog is being used by
	 */
	public EndDialog(String name, int happiness, String phoneNumber, Person p){
		label = new JLabel();
		myPerson = p;
		setLayout(new BorderLayout());
		if(happiness<=0){
			face = loadImage(name+"Mad");
			label.setText("I am never talking to you again");
		}
		else if (happiness == 1){
			face = loadImage(name+"Neutral");
			label.setText("Maybe we'll talk again sometime");
		}
		else{
			face = loadImage(name+"Happy");
			label.setText("Here is my #" + phoneNumber);
		}
		setSize(400,400);
		add(new JLabel(new ImageIcon(face)), BorderLayout.NORTH);
		myPerson.reset();
		add(label, BorderLayout.SOUTH);
		Main.frame.remove(myPerson);
		Main.frame.add(myPerson.getLoc().pickPerson());
		setVisible(true);
		pack();
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
