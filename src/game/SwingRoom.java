package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLayeredPane;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SwingRoom extends JFrame {

    private JPanel roomArea;

    /**
     * Launch the room template
     * 
     * Room needs to be a generic type with methods to support
     * adding and subtracting components based which Room the player is in
     * Required methods to integrate include:
     * Inventory display, monster display, treasure, score, room background, room descr.
     * Need to figure out how to hide/show objects based on situation
     * Event handlers should be able to deal with objects
     */
    
    /**
     * Create the frame.
     */
    public SwingRoom() {
        //initial setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        roomArea = new JPanel();
        roomArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(roomArea);
        roomArea.setLayout(new CardLayout(0, 0));
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBackground(Color.GRAY);
        layeredPane.setOpaque(false);
        roomArea.add(layeredPane, "");
        layeredPane.setLayout(null);
        
        //these are the room direction buttons - need to link them to backgrounds
        JButton roomN = new JButton("N");
        roomN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        roomN.setIcon(null);
        roomN.setEnabled(true);        
        roomN.setBackground(new Color(128, 128, 128));        
        roomN.setOpaque(true);
        roomN.setBounds(730, 354, 80, 41);        
        layeredPane.add(roomN);
        
        JButton roomW = new JButton("W");
        roomW.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        roomW.setIcon(null);
        roomW.setEnabled(true);
        roomW.setForeground(new Color(0, 0, 0));         
        roomW.setBackground(new Color(128, 128, 128));
        roomW.setOpaque(true);
        roomW.setBounds(685, 394, 80, 41);        
        layeredPane.add(roomW);
        
        JButton roomS = new JButton("S");
        roomS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        roomS.setIcon(null);
        roomS.setEnabled(true);        
        roomS.setBackground(new Color(128, 128, 128));
        roomS.setOpaque(true);
        roomS.setBounds(730, 433, 80, 41);        
        layeredPane.add(roomS);
        
        JButton roomE = new JButton("E");
        roomE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        roomE.setIcon(null);
        roomE.setEnabled(true);        
        roomE.setBackground(new Color(128, 128, 128));
        roomE.setOpaque(true);
        roomE.setBounds(777, 394, 80, 41);        
        layeredPane.add(roomE);
        //
        //Exit button upper right corner
        JButton exitButton = new JButton("EXIT");        
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        exitButton.setEnabled(true);
        exitButton.setIcon(null);
       
        exitButton.setForeground(new Color(0, 0, 0));
        exitButton.setBackground(new Color(128, 128, 128));
        
        exitButton.setOpaque(true);
        exitButton.setBounds(743, 0, 114, 41);
       
        layeredPane.add(exitButton);
        
        //this will be the room description scroll
        //need to figure out how to get descriptions to swap out
        Icon scroll = new ImageIcon("scroll2.png");
        JLabel scrollLabel = new JLabel(scroll, JLabel.CENTER);
        scrollLabel.setBounds(0, 0, 687, 124);
        layeredPane.add(scrollLabel);
        
        //this will be list of treasures or points
        JLabel inventory = new JLabel(" Inventory List Placeholder");
        inventory.setBackground(new Color(0, 100, 0));
        inventory.setForeground(new Color(255, 255, 255));
        inventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inventory.setHorizontalAlignment(SwingConstants.CENTER);
        inventory.setBounds(0, 317, 179, 185);
        layeredPane.add(inventory);
        
        Icon fairy = new ImageIcon("fairy.png");
        JLabel fairyPlace = new JLabel(fairy, JLabel.CENTER);
        fairyPlace.setBounds(218, 152, 180, 185);
        layeredPane.add(fairyPlace);
        
        //take treasure button - can't get this to work right now
        JButton treasureButton = new JButton(new ImageIcon("treasure.png"));        
        treasureButton.setBounds(408, 330, 171, 124);
        treasureButton.addMouseListener(new MouseAdapter() {
            //write method to have something happen when click on treasure
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        layeredPane.add(treasureButton);
        
        //need to write a method that swaps out background images  
        Icon bgIcon = new ImageIcon("hallway.jpg");
        JLabel backgroundLbl = new JLabel(bgIcon, JLabel.CENTER);
        backgroundLbl.setForeground(new Color(0, 0, 0));
        backgroundLbl.setBackground(new Color(128, 128, 0));
        backgroundLbl.setBounds(0, 0, 858, 502);
        layeredPane.add(backgroundLbl); 
    }
}
