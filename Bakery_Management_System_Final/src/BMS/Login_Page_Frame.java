package BMS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_Page_Frame {

	public static void Login_Page_Frame_Code() {
	
	JFrame frame1 = new JFrame("Login");
	JOptionPane pane = new JOptionPane();
	
	JLabel label1 = new JLabel("Login");
	label1.setBounds(290,50,150,30);
	label1.setFont(new Font("Times New Roman", Font.BOLD,25));

	
	JLabel lblUsername = new JLabel("Username");
	lblUsername.setBackground(Color.BLACK);
	lblUsername.setForeground(Color.BLACK);
	lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblUsername.setBounds(200,140,100,25);
	
	
	JTextField usernameText = new JTextField();
	usernameText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	usernameText.setBounds(300,140,170,25);
	
	
	JLabel lblPassword = new JLabel("Password");
	lblPassword.setBackground(Color.CYAN);
	lblPassword.setForeground(Color.BLACK);
	lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	lblPassword.setBounds(200,200,100,25);
	
	
	JPasswordField passwordText = new JPasswordField();
	passwordText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	passwordText.setBounds(300,200,170,25);

	
	JButton login = new JButton("Login");
	login.setBounds(300, 260, 100, 27);
	login.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	
	
	login.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Login_Page l = new Login_Page(usernameText.getText(), passwordText.getText());
			
			
			try {
				ResultSet x = Login_Page_Connectivity.Login_Page_Connectivity_Code(l);
				Connection a = Connective.getConnection();
				if(x.next()){
					
					
					JOptionPane.showMessageDialog(login, "You have successfully logged in");
					Home.Home_Code();
					System.out.println("You have successfully logged in");
					frame1.dispose();
					a.close();
					
				} else {
					JOptionPane.showMessageDialog(login, "Wrong Username & Password");
					a.close();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	
	
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setContentPane(new JLabel(new ImageIcon("D:/Project/Images/Bakery4.jpg")));
	frame1.setLayout(new FlowLayout());
	
	frame1.add(label1);
	frame1.add(lblUsername);
	frame1.add(usernameText);
	frame1.add(lblPassword);
	frame1.add(passwordText);
	frame1.add(login);
	
	frame1.setSize(1120, 575);
	frame1.setLayout(null);
	frame1.setLocationRelativeTo(null);
	frame1.setVisible(true);
	}
	
}
