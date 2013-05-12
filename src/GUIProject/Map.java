package GUIProject;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
/**
 * this class should display an image, and allow the player to move around that image to several location objects, will load a location object, which will select your person object
 * @author Stephen Wen
 *
 */
public class Map extends JPanel{
	Image map;
	Location[] locations;
	Player player;

	/**
	 * 
	 */
	public Map(){
		
	}
	
	
	/**
	 * 
	 */
	public Location getLoc(){
		int index = 0;
		for(int i = 0; i < locations.length;i++){
			if(Math.sqrt(Math.pow(locations[i].getLoc().x - player.getLoc().x,2) + Math.pow(locations[i].getLoc().y - player.getLoc().y,2)) <
					Math.sqrt(Math.pow(locations[index].getLoc().x - player.getLoc().x,2) + Math.pow(locations[index].getLoc().y - player.getLoc().y,2))){
				index =i;
			}
		}
		return locations[i];
	}
	
}
