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
		people = new Person[5];
		for(int i = 0; i < people.length;i++){
			people[i] = new Person();
		}
	}
	
	public Person pickPerson(){
		return people[(int)(Math.random()*people.length)];
	}
	
}
