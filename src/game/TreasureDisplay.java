package game;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TreasureDisplay extends JLabel {
    private JLabel background;
    private JLabel t1;
    private JLabel t2;
    private JLabel t3;
    private JLabel t4;
    private JLabel t5;
    private JLabel t6;
    private ImageIcon image;
    
    /**
     * Create the panel.
     */
    public TreasureDisplay() {
        setUpDisplay();

    }
    /**
     * Attempted to set up treasure row to display treasures
     * Not working yet
     */
    public void setUpDisplay() {
        image = new ImageIcon("images/bitcoinS.png");//would be input after correct question
        t1 = new TreasureLabel(382, 145, image);
        t1.setVisible(true);
        //maybe should be an array that gets filled with treasures
        
                
    }
    
   
}
