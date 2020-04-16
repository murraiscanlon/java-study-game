package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpMsg extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	PopUpMsg dialog;
	
	 public PopUpMsg() {
		 
			setBounds(100, 100, 550, 375);
			getContentPane().setLayout(null);
			contentPanel.setBounds(0, 0, 550, 375);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setLayout(null);
			setLocationRelativeTo(null);
			//setSize(500, 350);
			
			getContentPane().add(contentPanel);
			contentPanel.setBackground(Color.WHITE);
			contentPanel.setVisible(true);
			
			JLabel dragonImage = new JLabel("");
			dragonImage.setIcon(new ImageIcon("images/dragon2.jpg"));
			dragonImage.setBounds(0, 0, 550, 280);
			contentPanel.add(dragonImage);
			
			JButton continueButton = new JButton("CONTINUE");
			continueButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			continueButton.setBounds(35, 180, 116, 33);
			contentPanel.add(continueButton);
		}
	 
	 


	public static void main(String[] args) {
		PopUpMsg pop = new PopUpMsg();
		pop.launchPopUp();	
		
	}

 public void launchPopUp() {
		try {
			PopUpMsg dialog = new PopUpMsg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
 }

 }
 
 
 
 
 

