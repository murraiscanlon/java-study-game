package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Window.Level;

import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JTextPane;

public class SwingGameOver extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel scroll;
    private JLabel bgLabel;
    private JLabel scrollText;
    private JLabel wizardPlace;
    private JLabel wizardPlace1;
    private JLabel scoreLabel;
    private JEditorPane loseMsg;
    private JEditorPane winMsg;
    private JButton exitButton;
    private JButton playAgain;
    private Score score;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    SwingGameOver frame = new SwingGameOver();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public SwingGameOver() {
        /**Sets up initial frame**/
        initGameOver();
        
        /**Sets up scroll**/        
        setUpScroll();
        
        /**Sets up Win message when player wins***/
        setUpWinMsg();
        
        /***Sets up Lose message when player loses***/
        setUpLoseMsg();        
        
        /**Sets up quit game button**/
        setUpQuitButton();
        
        /**Sets up play again button**/
        setUpPlayAgainButton();
        
        /***Sets up score display***/
        setUpScoreDisplay();
              
        /***Sets up background image**/
        setUpBackground();
        
    }
    /**
     * Winner      
     */
    public void getWinMsg() {
        //Displays the winning message and hides losing message
        wizardPlace.setVisible(true);
        wizardPlace1.setVisible(false);
        winMsg.setVisible(true); 
        loseMsg.setVisible(false);       
        
    }
    /**
     * Loser
     */
    public void getLoseMsg() {
        //displays the losing message and hides winning message
        loseMsg.setVisible(true);
        winMsg.setVisible(false);
        wizardPlace1.setVisible(true);
        wizardPlace.setVisible(false);   
        
        
    }
    //need to check if there's a parseInt for displaying numbers
//    public void getFinalScore() {
//        scoreLabel.setText(score.getCurrentScore());//throws NPE 
//    }
    
    /**
     * Helper Methods
     */
    
    /**
     * Method to initialize Game Over page
     */
    public void initGameOver() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
    /**
     * Method to set up Game Over banner
     */
    public void setUpScroll() {
        scrollText = new JLabel();
        scrollText.setFont(new Font("Castellar", scrollText.getFont().getStyle(), 30));
        scrollText.setText("GAME OVER!");
        scrollText.setBounds(134, 34, 600, 100);
        scrollText.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(scrollText);
        
        //Sets scroll location top center with image
        scroll = new JLabel();                        
        scroll.setIcon(new ImageIcon("images/scroll2.png"));        
        scroll.setBounds(150, 30, 650, 125);        
        contentPane.add(scroll);
        setVisible(true);        
    }
    /**
     * Method to establish Quit button
     */
    public void setUpQuitButton() {
    //Exit button upper right corner, has same format as Direction Button
        exitButton = new DirectionButton("QUIT",775, 0);        
        exitButton.setBounds(761, 10, 113, 23);
        
        exitButton.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               System.exit(0);
           }
       });
        contentPane.add(exitButton);
    }
    /**Method to set up Play Again option
     * Includes button with action
     */
    public void setUpPlayAgainButton() {
        playAgain = new JButton("PLAY AGAIN");
        playAgain.setBackground(Color.GRAY);
        playAgain.setBounds(10, 10, 113, 23);
        
        playAgain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                //close current frame here  
                dispose();   
                //opens SwingEnterPage
                new SwingEnterPage();                          
                
            }
        });
        contentPane.add(playAgain);
    }
    /**
     * Method to set up the Win message from Wizard Arvind 
     */
    public void setUpWinMsg() {
        //Places the winning wizard pose 
        wizardPlace = new JLabel();
        wizardPlace.setHorizontalAlignment(SwingConstants.CENTER);
        wizardPlace.setIcon(new ImageIcon("images/wizard1S.png"));
        wizardPlace.setBounds(382, 145, 400, 405);
        wizardPlace.setVisible(false);
        contentPane.add(wizardPlace);
        
        //Creates the message player will see
        winMsg = new JEditorPane();
        winMsg.setForeground(Color.BLACK);
        winMsg.setContentType("text/html");
        winMsg.setEnabled(false);
        winMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        winMsg.setEditable(false);
        winMsg.setText("Wizard Arvind: Thank you for saving me! Your exemplary\r\nJava knowledge exceeded my expectations. Best wishes\r\non your journey.");
        winMsg.setBounds(134, 273, 285, 70);
        winMsg.setVisible(false);
        contentPane.add(winMsg);
         
    }
    /**
     * Method to set up the Lose message from Wizard Arvind
     */
    public void setUpLoseMsg() {
        //Sets losing message
        loseMsg = new JEditorPane();
        loseMsg.setForeground(Color.BLACK);
        loseMsg.setContentType("text/html");
        loseMsg.setText("Wizard Arvind: Your Java knowledge is lacking. \r\nPlay again to free me from the Java Monsters!");
        loseMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loseMsg.setEnabled(false);
        loseMsg.setEditable(false);
        loseMsg.setVisible(false);
        loseMsg.setBounds(451, 273, 252, 70);
        contentPane.add(loseMsg);
        
        //Sets wizard image for losing view
        wizardPlace1 = new JLabel();
        wizardPlace1.setHorizontalAlignment(SwingConstants.CENTER);
        wizardPlace1.setIcon(new ImageIcon("images/wizard2S.png"));
        wizardPlace1.setBounds(108, 145, 400, 405);
        wizardPlace1.setVisible(false);
        contentPane.add(wizardPlace1);
    }
    /**
     * Set up the score display
     */
    public void setUpScoreDisplay() {
        //Score display placeholder until scoring method is written
          scoreLabel = new JLabel("FINAL SCORE: " );
          scoreLabel.setBackground(Color.GRAY);
          scoreLabel.setForeground(Color.WHITE);
          scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
          scoreLabel.setOpaque(true);
          scoreLabel.setBounds(360, 123, 160, 81);
          contentPane.add(scoreLabel);
      }
    /**
     * Method to set up Background image
     */
    public void setUpBackground() {
        bgLabel = new JLabel();
        bgLabel.setIcon(new ImageIcon("images/GameOver.jpg"));
        bgLabel.setBounds(5, 5, 900, 600);
        contentPane.add(bgLabel);
    }
    
  
}
