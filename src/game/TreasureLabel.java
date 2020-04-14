package game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TreasureLabel extends JLabel {
    
    private static final long serialVersionUID = 1L;
    /**
     * Attempted to create row of labels for treasure
     * @param x
     * @param y
     * @param image
     */
    public TreasureLabel(int x, int y, ImageIcon image) {
               
        this.setForeground(new Color(0, 0, 0));
        this.setBackground(Color.LIGHT_GRAY);
        this.setIcon(image);
        this.setEnabled(true);
        this.setBounds(x, y, 100, 100);
        
        
    }

}
