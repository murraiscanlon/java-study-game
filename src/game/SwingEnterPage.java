package game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class to initiate Game Start with an entrance page
 * @author Team 30
 *
 */
public class SwingEnterPage {

    private JFrame frame;
    private JTextField textNameField;
    private JLabel gameTitle;


    /**
     * Constructor for SwingEnterPage
     * Creates and initialize the application.
     * 
     */
    public SwingEnterPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * Creates game Title label
     * Establishes Start button and Text Field to enter name
     */
    private void initialize() {
    	
       
    	/**
    	 * This is the code that will allow a background image
    	 * but need to figure out why the layout is hiding the image.
    	 */
    	//add background image
		Icon icon = new ImageIcon("enter2.jpg");
		JLabel image = new JLabel(icon, JLabel.CENTER);
		
		
		
        frame = new JFrame();
        
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);//THIS IS THE LINE HIDING THE IMAGE
        frame.getContentPane().add(image);
        frame.setVisible(true);
        
       
        //Blank text field
        textNameField = new JTextField();
        textNameField.setBounds(305, 315, 230, 40);
        frame.getContentPane().add(textNameField);
        textNameField.setColumns(10);
        
        //Label above blank text field w/instructions to enter name
        JLabel playerNameLabel = new JLabel("Enter Player Name");
        playerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        playerNameLabel.setBounds(330, 257, 200, 30);
        frame.getContentPane().add(playerNameLabel);
        
        gameTitle = new JLabel("J A V E N T U R E");
        gameTitle.setIcon(null);
        gameTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
        gameTitle.setBounds(255, 50, 355, 80);
        frame.getContentPane().add(gameTitle);
        

    }

    /**
     * Launches the application window
     * Will later be linked to other Swing Classes
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingEnterPage window = new SwingEnterPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
