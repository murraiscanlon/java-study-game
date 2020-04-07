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

public class SwingEnterPageM3 extends JFrame {

	private JPanel jp1;
	private JTextField nameTextField;
	private String currentImage;
	
	
	/**
	 * Contructor for this class
	 */
	public SwingEnterPageM3() {
		
		currentImage = "C:\\Users\\Murrai.Scanlon\\Desktop\\github\\final-project-team-30\\images\\enter2.jpg";
		
		setBackground(Color.BLACK);
		
		//I guess this is the default window built from the try/catch in main??
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 563);
		jp1 = new JPanel();
		jp1.setForeground(Color.BLACK);
		jp1.setBackground(Color.BLACK);
		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp1);
		jp1.setLayout(null);
		
		//title label
		JLabel titleLabel = new JLabel("JAVENTURE");
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setLabelFor(titleLabel);
		titleLabel.setBounds(137, 57, 607, 121);
		jp1.add(titleLabel);
		
		//enter name label CAN"T GET THE BACKGROUND TO BLACK
		JLabel enterPlayerNameLabel = new JLabel("Enter Player Name");
		enterPlayerNameLabel.setForeground(Color.WHITE);
		enterPlayerNameLabel.setBackground(Color.BLACK);
		enterPlayerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterPlayerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		enterPlayerNameLabel.setBounds(274, 235, 286, 57);
		jp1.add(enterPlayerNameLabel);
		
		//This is where the player enters their name
		nameTextField = new JTextField();
		nameTextField.setBackground(Color.BLACK);
		nameTextField.setForeground(Color.WHITE);
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameTextField.setBounds(284, 297, 289, 42);
		jp1.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel imageHolderLabel = new JLabel("");
		imageHolderLabel.setBackground(Color.BLACK);
		imageHolderLabel.setIcon(new ImageIcon(currentImage));
		imageHolderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageHolderLabel.setBounds(10, 10, 848, 506);
		jp1.add(imageHolderLabel);
	}
	
	
	

	/**
	 * Launch the application.
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
