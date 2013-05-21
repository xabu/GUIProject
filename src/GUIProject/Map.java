package GUIProject;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * This class was not completed and is not used in the program, it would be implemented as a way to select which person to talk to first. MJ was told to finish this class several times and he did no work.
 * this class should display an image, and allow the player to move around that image to several location objects, will load a location object, which will select your person object
 * @author Stephen Wen
 *
 */
public class Map extends JPanel implements KeyListener{
	Image map;
	Location[] locations;
	Player player;

	/*
	public Map(){
		locations = new Location[3];
		for(int i = 0; i < locations.length;i++){
			locations[i] = new Location();
		}
		player = new Player();
		JTextArea a = new JTextArea();
		a.setEditable(false);
		a.addKeyListener(this);
		add(a);
	}*/
	public Map (String[][] text){
		locations = new Location[3];
		player = new Player();
		for(int i = 0; i < locations.length;i++){
			locations[i] = new Location(text[i]);
		}
		JTextArea a = new JTextArea();
		a.setEditable(false);
		a.addKeyListener(this);
		add(a);
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
		System.out.println("Got into key event" + e.getKeyChar());
		int key = e.getKeyCode();
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
