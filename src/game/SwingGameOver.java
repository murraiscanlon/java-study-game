package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JEditorPane loseMsg;
    private JEditorPane winMsg;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingGameOver frame = new SwingGameOver();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SwingGameOver() {
        //Sets up initial frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
      //Sets Game Over text over scroll
        scrollText = new JLabel();
        scrollText.setFont(new Font("Castellar", scrollText.getFont().getStyle(), 30));
        scrollText.setText("GAME OVER!");
        scrollText.setBounds(134, 34, 600, 100);
        scrollText.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(scrollText);
        
        //Sets scroll location top center
        scroll = new JLabel();                        
        scroll.setIcon(new ImageIcon("images/scroll2.png"));        
        scroll.setBounds(150, 30, 650, 125);        
        contentPane.add(scroll);
        setVisible(true);        
        
        JButton loseB = new JButton("LOSE");
        loseB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
                loseMsg.setVisible(true);
                winMsg.setVisible(false);
                wizardPlace1.setVisible(true);
                wizardPlace.setVisible(false);
                
            }
        });
        loseB.setBounds(239, 489, 89, 23);
        contentPane.add(loseB);
        
        JButton winB = new JButton("WIN");
        winB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                wizardPlace.setVisible(true);
                wizardPlace1.setVisible(false);
                winMsg.setVisible(true); 
                loseMsg.setVisible(false);
              
            }
        });
        winB.setBounds(503, 489, 89, 23);
        contentPane.add(winB);
        
      //Sets wizard image for winning view
        wizardPlace = new JLabel();
        wizardPlace.setHorizontalAlignment(SwingConstants.CENTER);
        wizardPlace.setIcon(new ImageIcon("images/wizard1S.png"));
        wizardPlace.setBounds(382, 145, 400, 405);
        wizardPlace.setVisible(false);
        contentPane.add(wizardPlace);
        
        //Sets winning message
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
        
        //Sets up buttons for Exit and Restarting the game
        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(10, 5, 113, 23);
        contentPane.add(exitButton);
        
        JButton playAgain = new JButton("PLAY AGAIN");
        playAgain.setBounds(761, 5, 113, 23);
        contentPane.add(playAgain);
        
        JLabel scoreLabel = new JLabel("FINAL SCORE");
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setBounds(10, 156, 88, 370);
        contentPane.add(scoreLabel);
              
        //Sets background image
        bgLabel = new JLabel();
        bgLabel.setIcon(new ImageIcon("images/GameOver.jpg"));
        bgLabel.setBounds(5, 5, 900, 600);
        contentPane.add(bgLabel);
        
       
        
       
    }
    public void showWizardMessage() {
                
//        if (Score == winning number) {
//          wizard = new ImageIcon("images/wizard1.png");  
//            winmsg.setText("Thank you for saving me!");
//        }
//        else
//          wizard = new ImageIcon("images/wizard2.png");  
//            losemsg.setText("Sadly, you did not defeat the Java Monsters,"
//                        + "and I remain their captive.");
    }
    
    /**
     * Method to swap out components based on winning game
     * 
     */
    public void displayFinalScore() {
        
    }
}