package BMS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Home {
	
	public static void Home_Code(){


//		rgba(205,225,156,255)
//		rgba(250,225,227,255)
	JFrame frame2 = new JFrame("Home");
	
	JLabel heading = new JLabel("WELCOME TO CHANDURAM'S BAKERY");
	heading.setBounds(900,80,650,50);
	heading.setForeground(Color.BLACK);
	heading.setFont(new Font("Times New Roman", Font.BOLD,32));
	frame2.add(heading);

	PanelButton.PanelButtonCode(frame2, 0);
	
	
	JPanel panel2 = new JPanel();
	JLabel img = new JLabel(new ImageIcon("D:/Project/Images/Bakery1.1.png"));
	panel2.add(img);
	panel2.setBounds(900, 300, 595, 419);
	panel2.setBackground(new Color(253,246,241));
	frame2.add(panel2);
	
	
	frame2.getContentPane().setBackground(new Color(253,246,241));
	frame2.setLayout(new FlowLayout());
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.setLayout(null);
	frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame2.setVisible(true);
	}
}
