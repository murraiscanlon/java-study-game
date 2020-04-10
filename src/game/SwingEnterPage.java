package game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

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
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //Sets the button to go to next screen
        ImageIcon buttonPic = new ImageIcon("startButton.png");
        JButton startButton = new JButton("", buttonPic);
        startButton.setPreferredSize(new Dimension(140, 35));
        startButton.setOpaque(true);
        
        //Adds functionality for clicking on Start button
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent click) {
                StoryPage page2 = new StoryPage();//link to second page
                page2.setVisible(true); //brings up next screen 
                frame.setVisible(false);//closes enter page window
            }

        });
        frame.getContentPane().setLayout(null);
        startButton.setBounds(330, 458, 140, 45);
        frame.getContentPane().add(startButton);
        
        //Blank text field
        textNameField = new JTextField();
        textNameField.setBackground(Color.LIGHT_GRAY);
        textNameField.setHorizontalAlignment(SwingConstants.CENTER);
        textNameField.addKeyListener(new KeyAdapter() {
            //need to figure out where to store name input
            @Override
            public void keyTyped(KeyEvent type) {
                String name = textNameField.getText();
            }
        });
        textNameField.setForeground(Color.BLACK);
        textNameField.setBounds(340, 431, 115, 20);
        frame.getContentPane().add(textNameField);
        textNameField.setColumns(10);
        
        //Label above blank text field w/instructions to enter name
        JLabel playerNameLabel = new JLabel("Player Name:");
        playerNameLabel.setLabelFor(textNameField);
        playerNameLabel.setIcon(null);
        playerNameLabel.setBackground(SystemColor.window);
        playerNameLabel.setForeground(Color.WHITE);
        playerNameLabel.setOpaque(false);
        playerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        playerNameLabel.setBounds(350, 400, 91, 30);
        frame.getContentPane().add(playerNameLabel);
        
        gameTitle = new JLabel("J A V E N T U R E");
        gameTitle.setForeground(Color.GRAY);
        gameTitle.setIcon(null);
        gameTitle.setFont(new Font("Castellar", gameTitle.getFont().getStyle(), 43));
        gameTitle.setBounds(232, 45, 455, 49);
        frame.getContentPane().add(gameTitle);
        
        Icon icon = new ImageIcon("enterpic.jpg");          
        JLabel image = new JLabel(icon, JLabel.CENTER);
        image.setBounds(0, 0, 900, 600);
        frame.getContentPane().add(image);        
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
