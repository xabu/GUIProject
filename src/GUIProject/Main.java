package GUIProject;
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
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		//testPerson();
		testLocation();
	}
	public static void testPerson(){
		frame = new JFrame();//this is the frame to hold everything
		Person p = new Person();//this is a test person to make sure people are working
		frame.getContentPane().add(p);//adding the panel to the frame
		p.validate();
		frame.validate();
		frame.pack();
		frame.setVisible(true);
	}
	public static void testLocation(){
		frame = new JFrame();
		String testInput = "20,300\n5,1,Jenny,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself\n5,1,Joy,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself\n5,1,May,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself,You are scaring me#Fuck you#Who are you#Don't worry I'm clean,You seem ok#You wanna fuck?#I sure am ok#You seem ok yourself,Hey you're cute#Suck my dick#Yeah I am!#Not bad looking yourself";
		String[] testArr = testInput.split("\n");
		Location l = new Location(testArr);
		frame.add(l.pickPerson());
		frame.pack();
		frame.setVisible(true);
	}
}
