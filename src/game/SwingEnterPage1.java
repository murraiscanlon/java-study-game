package game;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingEnterPage1 extends JFrame {

	private JPanel contentPane;
	private JTextField userInput;
	private String userName = "";
	
	/**
	 * Create the frame.
	 */
	public SwingEnterPage1() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.BLACK);
		layeredPane.setBounds(40, 10, 913, 699);
		contentPane.add(layeredPane);
		
		JLabel titleLabel = new JLabel("JAVENTURE");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 99));
		titleLabel.setBounds(130, 10, 669, 84);
		layeredPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("Player Name: ");
		nameLabel.setBackground(Color.BLACK);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(373, 237, 184, 39);
		layeredPane.add(nameLabel);
		
		userInput = new JTextField();
		userInput.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		userInput.setBackground(new Color(192, 192, 192));
		userInput.setBounds(356, 286, 214, 39);
		layeredPane.add(userInput);
		userInput.setColumns(10);
		
		JButton enterButton = new JButton("ENTER");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitAction();
			}
		});
		enterButton.setBackground(Color.BLACK);
		enterButton.setForeground(Color.WHITE);
		enterButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		enterButton.setBounds(394, 492, 125, 39);
		layeredPane.add(enterButton);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setIcon(new ImageIcon("C:\\Users\\Murrai.Scanlon\\Desktop\\github\\final-project-team-30\\enter1.jpg"));
		imageLabel.setBounds(0, 5, 913, 689);
		layeredPane.add(imageLabel);
	}
	
	public void submitAction() {
		userName = userInput.getText();
		System.out.println(userName);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingEnterPage1 frame = new SwingEnterPage1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
