package GUIProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private BufferedImage image;

    public ImagePanel(String Filename) {
       try {                
           image = ImageIO.read(new File("src/GUIProject/"+Filename+".jpg"));
       } catch (IOException ex) {
            System.out.println("Couldn't find the file");
       }
    }
    public ImagePanel(BufferedImage img){
    	image = img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
}
