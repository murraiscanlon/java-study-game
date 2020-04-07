package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;


/**
 * This is an attempt to get a background image on the splash screen.
 * 
 * PROBLEM #1:
 * "It works on my machine" but I am having trouble finding the picture unless I use the 
 * path on my machine. I moved the image files to a separate image folder and 
 * now I just can't get my code to find the enter2.jpg unless I give it a direct path.
 * 
 * PROBLEM #2:
 * I can't get the background color for the "Enter Player Name" Label to change to black.
 * 
 * PROBLEM #3:
 * When the player enters their name, we need to figure out where to send it.
 * 
 *
 */
public class SwingEnterPageM3 extends JFrame {

	private JPanel jp1;
	private JTextField nameTextField;
	private String currentImage;
	static private String playerName; //this isn't used
	
	
	/**
	 * Constructor for this class
	 * 
	 * Right now I have everything loading as soon as this class is called.
	 * There is an invoke later in the main method here, just for testing. That will
	 * need to be integrated into the gamemanager maybe.
	 */
	public SwingEnterPageM3() {
		
		currentImage = "C:\\Users\\Murrai.Scanlon\\Desktop\\github\\final-project-team-30\\images\\enter2.jpg";
		
		setBackground(Color.BLACK);
		
		//This is the default window built from the try/catch in main
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 563);
		jp1 = new JPanel();
		jp1.setForeground(Color.BLACK);
		jp1.setBackground(Color.BLACK);
		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp1);
		jp1.setLayout(null);
		
		//Title of the splash screen
		JLabel titleLabel = new JLabel("JAVENTURE");
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setLabelFor(titleLabel);
		titleLabel.setBounds(137, 57, 607, 121);
		jp1.add(titleLabel);
		
		//Text that says "Enter Player Name"  CAN"T GET THE BACKGROUND TO BLACK
		JLabel enterPlayerNameLabel = new JLabel("Enter Player Name");
		enterPlayerNameLabel.setForeground(Color.WHITE);
		enterPlayerNameLabel.setBackground(Color.BLACK);
		enterPlayerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterPlayerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		enterPlayerNameLabel.setBounds(274, 235, 286, 57);
		jp1.add(enterPlayerNameLabel);
		
		//This is the actual text field where the player will enter their name
		//need to figure out how to store the input and where to send it.
		//surely we don't need a scanner for this?
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setBackground(Color.BLACK);
		nameTextField.setForeground(Color.WHITE);
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		nameTextField.setBounds(284, 297, 289, 42);
		jp1.add(nameTextField);
		nameTextField.setColumns(10);
		
		
		//This label is what holds the background image
		JLabel imageHolderLabel = new JLabel("");
		imageHolderLabel.setBackground(Color.BLACK);
		imageHolderLabel.setIcon(new ImageIcon(currentImage));
		imageHolderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageHolderLabel.setBounds(10, 10, 848, 506);
		jp1.add(imageHolderLabel);
	}
	
	
	

	/**
	 * This launches the application and will be moved if the class is ultimately used.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingEnterPageM3 frame = new SwingEnterPageM3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
