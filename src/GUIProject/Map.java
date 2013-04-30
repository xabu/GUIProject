package GUIProject;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
/**
 * this class should display an image, and allow the player to move around that image to several location objects, will load a location object, which will select your person object
 * @author Stephen Wen
 *
 */
public class Map extends JPanel {
	Image map;
	Location[] locations;

	/**
	 * 
	 */
	public Map(){
		
	}
	
	
	/**
	 * 
	 */
	public Location getLoc(){
		return new Location();
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g){
		
	}
}
