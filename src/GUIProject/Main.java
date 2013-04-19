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
		frame = new JFrame();
		frame.add(new Person());
		frame.pack();
		frame.setVisible(true);
	}
}
