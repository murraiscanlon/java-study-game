package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

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
        JLabel image2 = new JLabel(icon2, JLabel.CENTER);
        image2.setBounds(5, 27, 392, 480);
        contentPane.add(image2);
        
        
    }

}
