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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StoryPage extends JFrame {

    /**
     * Class to 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel image2;
    private JTextPane story;
    private ImageIcon icon2;
    private ImageIcon buttonPic1;
    private JButton enter;
    private ImageIcon bgImage;
    private JLabel background;

    /**
     * Create the frame.
     */
    public StoryPage() {
        /**Sets up the initial panel**/
        initializeStoryPage();
        
        /**Sets up scroll with story**/
        setUpScroll();
        
        /**Sets up scroll image**/
        setScrollImage(); 
        
        /**Sets up ENTER button**/        
        setEnterButton();
        
        /**Sets up background image**/
        setUpBackground();
         
    }
    /**
     * Method to initialize Story Page
     */
    public void initializeStoryPage() {
        //Sets up JPanel on JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.DARK_GRAY);
        setContentPane(contentPane);
        
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
        
        //setScrollImage();
                
    }
    /**
     * Method to set up the scroll background
     */
    public void setScrollImage() {
        
        icon2 = new ImageIcon("scrollpage1.png");       
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
        buttonPic1 = new ImageIcon("enterButton.png");
        enter = new JButton("", buttonPic1);
        enter.setPreferredSize(new Dimension(140, 35));
        enter.setOpaque(true);
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                SwingRoom room = new SwingRoom();//link to second page
                room.setVisible(true); //brings up next screen                
                //need to figure out how to close current screen
            }
            
        });
        //enter.setFont(new Font("Tahoma", Font.PLAIN, 16));
        enter.setBounds(640, 360, 130, 40);
        contentPane.add(enter);
    }
    /**
     * Method to set up background image
     */
    public void setUpBackground() {
        bgImage = new ImageIcon("enterdoor.jpg");
        background = new JLabel(bgImage, JLabel.CENTER);
        background.setBounds(0, 0, 900, 600);
        contentPane.add(background);
         
    }
    
} 


