package GUIProject;

import java.awt.Image;
import java.awt.Point;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Location {
	Point coordinates;
	Person[] people;
	Image icon;
	
	public Location(){
		
	}
	
	public Person pickPerson(){
		return new Person();
	}
	
}
