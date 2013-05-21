package GUIProject;

import java.awt.Image;
import java.awt.Point;
/**
 * 
 * @author Stephen Wen
 *
 */
public class Location {
	private Point coordinates;
	private Person[] people;
	private Image icon;
	/*
	public Location(){
		people = new Person[2];
		for(int i = 0; i < people.length;i++){
			people[i] = new Person();
		}
		coordinates.x = 0;
		coordinates.y = 0;
	}*/
	public Location(String[] str){
		String [] strPoint = str[0].split(",");
		coordinates = new Point(Integer.parseInt(strPoint[0]),Integer.parseInt(strPoint[1]));
		people = new Person[2];
		for(int i = 0; i < people.length;i++){
			people[i] = new Person(str[i+1], this);
		}
	}
	public Person pickPerson(){
		return people[(int)(Math.random()*people.length)];
	}
	public Point getLoc(){
		return coordinates;
	}
	
}
