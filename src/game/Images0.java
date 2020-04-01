package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 * OVERVIEW:
 * This is a practice run at getting our own images to display using swing (used Jen's pictures from the visualization ppt).
 * This is a static class so it should be used as a picture display utility.
 * 
 * Just call Image.displayImage("name of image");
 * 
 * FURTHER WORK:
 * decide on specific images and refinement of the frame attributes.
 * try to incorporate click events maybe
 * I'm not really sure if I sould be using the SwingUtilities and I'm worried that this is thread safe
 * 
 * POTENTIAL IMPLEMENTATION IDEAS: 
 * Can be used with plane images like for a splash screen or
 * pictures with choices on them.
 * 
 * @author Team 30
 *
 */
public class Images0 {
	
	/**
	 * Right now, the calling method has to know Images' instance variables.	
	 */
	// instance variables
		static String dungeon = "dungeon0.jpg";
		static String enter = "enter0.jpg";
		static String splash = "splash0.jpg";
		static String tower = "tower0.jpg";

		// constructor
		Images0() {

		}

		
		/**
		 * This method displays one of the preset images on the screen for the user to see.
		 * Not sure if it should be an plain image or an image with listed options. . .
		 * the current examples contain both choices.
		 * 
		 * @param imageName
		 */
		public static void displayImage(String imageName) {

			
			//recieve name of image that the calling method wants and match it to a file name
			String currentImage = imageName;
			switch (currentImage) {
			case "dungeon":
				currentImage = dungeon;
				break;
			case "enter":
				currentImage = enter;
				break;
			case "splash":
				currentImage = splash;
				break;
			case "tower":
				currentImage = tower;
				break;
			}

			
			//display the desired picture to the screen as a new icon set in a JFrame
			Icon icon = new ImageIcon(currentImage);

			JLabel greeting = new JLabel(icon, JLabel.CENTER);
			greeting.setFont(new Font("serif", Font.PLAIN, 32));
			greeting.setForeground(Color.red);

			JFrame frame = new JFrame("JavaMonsters");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(greeting);
			frame.setSize(1000, 600);
			frame.setVisible(true);

		}


		
		//main method for testing
		public static void main(String[] args) {
			
			
			// call an image and have it displayed
			Images0.displayImage("dungeon");

		}


}
