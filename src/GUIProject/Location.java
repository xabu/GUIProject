package GUIProject;

import java.awt.Image;
import java.awt.Point;
/**
 * A class that describes a location at which one can find women to talk to
 * @author Stephen Wen
 *
 */
public class Location {
	private Point coordinates;
	private Person[] people;
	private Image icon;
	/**
	 * Creates a Location Object given a formatted String array, formatted as would be done in the Map class
	 * @param str an array of Strings including the coordinates of the location as well as the strings needed to create the Person Objects
	 */
	public Location(String[] str){
		String [] strPoint = str[0].split(",");
		coordinates = new Point(Integer.parseInt(strPoint[0]),Integer.parseInt(strPoint[1]));
		people = new Person[3];
		for(int i = 0; i < people.length;i++){
			people[i] = new Person(str[i+1], this);
		}
	}
	/**
	 * returns a randomly selected Person from the array of possible people
	 * @return
	 */
	public Person pickPerson(){
		return people[(int)(Math.random()*people.length)];
	}
	/**
	 * returns the coordinates of this location, was to be used in the incompleted Map class.
	 * @return
	 */
	public Point getLoc(){
		return coordinates;
	}
	
}
