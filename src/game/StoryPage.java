package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Class which brings up the background Story and game play methodology
 * Allows player to enter the castle
 * @author Team 30
 *
 */
public class StoryPage extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel image2;
    private JLabel background;
    private JTextPane story;
    private ImageIcon icon2;
    private ImageIcon buttonPic1; 
    private ImageIcon bgImage;
    private JButton enter; 
    private String playerName = "";
    
    /**
     * Constructor
     * Creates the frame.
     */
    public StoryPage(String playerName) {
        /**
         * Sets up the initial panel
         */
        initializeStoryPage(playerName);        
        /**
         * Sets up scroll with story
         */
        setUpScroll();        
        /**
         * Sets up scroll image
         */
        setScrollImage();         
        /**
         * Sets up ENTER button
         */        
        setEnterButton();        
        /**
         * Sets up background image
         */
        setUpBackground();
         
    }
    /**
     * Method to initialize Story Page
     */
    public void initializeStoryPage(String playerName) {
        //Sets up JPanel on JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        this.playerName = playerName;
    }
    
    /**
     * Method to set up scroll and background story
     */
    public void setUpScroll() {
        //Creates text pane to hold story text
        story = new JTextPane();
        story.setEditable(false);
        story.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        story.setText("Before you lies a looming castle, "
                        + "its moss-covered towers dark and damp. "
                        + "A great enemy has overrun the castle and "
                        + "captured Wizard Arvind, the most powerful "
                        + "wizard in all the land. Your mission is "
                        + "to defeat the lurking Java Monsters by"
                        + "\r\nstealing their treasure, a feat which "
                        + "can only be accomplished by correctly answering"
                        + " questions about their language. If you collect "
                        + "enough treasure, Wizard Arvind will be freed, and "
                        + "the Java Monsters will be banished from the realm."
                        + " Your Fairy GodTA will guide you on your journey. Good luck!");
        story.setBounds(144, 46, 264, 365);
        story.setOpaque(false);
        story.setVisible(true);
        contentPane.add(story);
        
        //setScrollImage();TODO delete later
                
    }
    /**
     * Method to set up the scroll background
     */
    public void setScrollImage() {
        
        icon2 = new ImageIcon("images/scrollpage1.png");       
        contentPane.setLayout(null);       
        image2 = new JLabel(icon2, SwingConstants.CENTER);
        image2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        image2.setVerticalAlignment(SwingConstants.TOP);
        image2.setBounds(75, 30, 400, 500);
        image2.setVisible(true);
        contentPane.add(image2);
    }
    /**
     * Method to create ENTER button and add action
     * Allows player to enter the castle
     */
    public void setEnterButton() {
        
        enter = new JButton("ENTER");
        enter.setBorder(new LineBorder(new Color(153, 153, 153), 2));
        enter.setFont(new Font("Tahoma", Font.BOLD, 18));
        enter.setBackground(new Color(60, 0, 0));
        enter.setForeground(Color.WHITE);
        enter.setHorizontalAlignment(SwingConstants.CENTER);
        enter.setOpaque(true);
        enter.setBounds(360, 460, 150, 45);
        

        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //closes current window
                dispose();
                //opens rooms
                SwingRoom room = new SwingRoom(playerName);//link to second page
                room.setVisible(true); //brings up next screen             
                
                
            }
            
        });
      
        contentPane.add(enter);
    }
    /**
     * Method to set up background image
     */
    public void setUpBackground() {
        bgImage = new ImageIcon("images/enterdoor.jpg");
        background = new JLabel(bgImage, JLabel.CENTER);
        background.setBounds(0, 0, 900, 600);
        contentPane.add(background);
         
    }
    
} 


