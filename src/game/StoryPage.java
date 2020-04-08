package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StoryPage extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public StoryPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.DARK_GRAY);
        setContentPane(contentPane);
        
          
        Icon icon2 = new ImageIcon("scroll_copy.png");
        contentPane.setLayout(null);
        
        JButton enter = new JButton("ENTER");
        enter.setBackground(Color.LIGHT_GRAY);
        enter.setOpaque(true);
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                SwingRoom room = new SwingRoom();//link to second page
                room.setVisible(true); //brings up next screen
                
                //need to figure out how to close current screen
            }
            
        });
        enter.setFont(new Font("Castellar", Font.PLAIN, 27));
        enter.setBounds(444, 340, 171, 41);
        contentPane.add(enter);
        JLabel image2 = new JLabel(icon2, JLabel.CENTER);
        image2.setBounds(5, 27, 392, 480);
        contentPane.add(image2);
        
        Icon bgImage = new ImageIcon("enterdoor.jpg");
        JLabel background = new JLabel((Icon) bgImage, JLabel.CENTER);
        background.setBounds(0, 0, 784, 561);
        contentPane.add(background);
        

    }
} 


