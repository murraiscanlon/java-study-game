package game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Class to consolidate treasure display Shows treasure icons when treasure is
 * won
 * 
 * @author Team 30 *
 */
public class TreasureLabel extends JLabel {
    /**
     * Instance Variables
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * 
     * @param x - x coordinate of label
     * @param y - y coordinate of label
     * @param image - treasure image to be displayed
     */
    public TreasureLabel(int x, int y, String image) {
        this.setIcon(new ImageIcon(image));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBackground(Color.GRAY);
        this.setBounds(x, y, 80, 80);
        this.setVisible(false);
    }

}
