package GUIProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * 
 * @author MJ Chen, Alvin Janes, Stephen Wen
 *
 */
public class Main {
	public static JFrame frame;
	public static Map baseMap;
	/**
	 * Main method to run the program
	 * @param args
	 */
	public static void main(String[] args){
		//testPerson();
		testLocation();
		//testMap();
	}
<<<<<<< HEAD
	public static void testLocation(){
		frame = new JFrame();
		Scanner sc;
		String testInput = "";
		try {
			sc = new Scanner(new File("src\\GUIProject\\otherFiles\\Input.txt"));
			while(sc.hasNextLine()){
				testInput += sc.nextLine()+"\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
		//String testInput = "20,300\n5,1,Jenny,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-888-4848\n5,1,Joy,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-214-8426\n5,1,May,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-845-2684";
=======
	public static void testPerson(){
		frame = new JFrame();//this is the frame to hold everything
		Person p = new Person("5,1,Jenny,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself");//this is a test person to make sure people are working
		frame.getContentPane().add(p);//adding the panel to the frame
		frame.pack();
		frame.setVisible(true);
	}
	public static void testLocation(){
		frame = new JFrame();
		String testInput = "20,300\n5,1,Jenny,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-888-4848\n5,1,Joy,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-214-8426\n5,1,May,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-845-2684";
>>>>>>> 776ef207e7ed1294222cc731cb1b03530c191bdd
		String[] testArr = testInput.split("\n");
		Location l = new Location(testArr);
		frame.add(l.pickPerson());
		frame.pack();
		frame.setVisible(true);
	}
	public static void testMap(){
		frame = new JFrame();
		String testInput = "20,300\n5,1,a,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-288-1177\n5,1,b,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-967-1111\n5,1,c,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna messk?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,647-439-0000\n\n20,300\n5,1,d,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-288-1177\n5,1,e,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-967-1111\n5,1,f,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,647-439-0000\n\n20,300\n5,1,g,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-288-1177\n5,1,h,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,416-967-1111\n5,1,i,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Screw you#Who are you#Don't worry I'm clean,You seem ok#You wanna mess?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,647-439-0000";
		String[] testArr = testInput.split("\n\n");
		String[][] testParam = new String[3][4];
		for(int i = 0; i < testParam.length;i++){
			testParam[i] = testArr[i].split("\n");
		}
		Map m = new Map(testParam);
		frame.getContentPane().add(m);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
