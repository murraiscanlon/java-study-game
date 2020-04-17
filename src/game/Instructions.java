package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.EventListenerList;
/**
 * Class to create Instructions Pop-up Box 
 * @author Team 30
 *
 */
//public class QuestionBoxDialog extends JDialog implements ActionListener, PropertyChangeListener {
public class Instructions extends JDialog {
    /**
     * Instance variables
     */
	private static final long serialVersionUID = 1L;
	//private EventListenerList listenerList = new EventListenerList();
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JLabel instruction;//TODO delete
	private JLabel javaMonsterImageLabel;
	private JButton okButton;

	public Instructions(Frame aFrame, Score score) {
		super(aFrame, true);

		/***** Creates the Base Frames *****/
		setUpUIFoundation();
		/***** Set Up Submit Button *****/
		setUpOkButton();
		/***** Set Up Monster Images *****/
		setUpMonsterImageBackground();
	}

	/**
	 * Method to establish the frame background
	 */
	public void setUpUIFoundation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 715);
		contentPane = new JPanel();
		contentPane.setSize(645, 705);
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 500);
		layeredPane.setBackground(Color.red);
		layeredPane.setBounds(10, 10, 645, 695);
		contentPane.add(layeredPane);
	}
	
	/*
	 * This method creates the OK button
	 */
	public void setUpOkButton() {
		okButton = new JButton("OK!");
		okButton.setBounds(365, 568, 110, 35);
		okButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		layeredPane.add(okButton);
	}

	/*
	 * This method creates the monster background
	 */
	public void setUpMonsterImageBackground() {

		/**
		 * Displays monster image as a background for the box frame
		 */
		javaMonsterImageLabel = new JLabel("");
		javaMonsterImageLabel.setVerticalAlignment(SwingConstants.TOP);
		javaMonsterImageLabel.setIcon(new ImageIcon("images/immortalBlock.png"));
		javaMonsterImageLabel.setBounds(0, 0, 645, 695);
		layeredPane.add(javaMonsterImageLabel);
		javaMonsterImageLabel.setVisible(true);

		setContentPane(contentPane);
	}
}
