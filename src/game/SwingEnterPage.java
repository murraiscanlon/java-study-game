package game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
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
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton startButton = new JButton("START");
        startButton.setBounds(330, 380, 170, 40);
        frame.getContentPane().add(startButton);
        
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
