package GUIProject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * this class should display an image, and allow the player to move around that image to several location objects, will load a location object, which will select your person object
 * @author Stephen Wen
 *
 */
public class Map extends JPanel implements KeyListener{
	Image map;
	Location[] locations;
	Player player;
	JLabel label;

	/**
	 * 
	 */
	public Map(){
		addKeyListener(this);
		label = new JLabel("default");
		add(label);
		label.addKeyListener(this);
	}
	
	
	/**
	 * 
	 */
	public Location getLoc(){
		int index = 0;
		for(int i = 0; i < locations.length;i++){
			if(locations[i].getLoc().distance(player.getLoc())<locations[index].getLoc().distance(player.getLoc())){
				index =i;
			}
		}
		return locations[index];
	}


	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Got into key event");
		int key = e.getKeyCode();
		label.setText(""+e.getKeyChar());
		switch(key){
			case KeyEvent.VK_UP:
				player.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				player.moveDown();
				break;
			case KeyEvent.VK_RIGHT:
				player.moveRight();
				break;
			case KeyEvent.VK_LEFT:
				player.moveLeft();
				break;
			case KeyEvent.VK_ENTER:
				removeAll();
				add(getLoc().pickPerson());
				break;
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
