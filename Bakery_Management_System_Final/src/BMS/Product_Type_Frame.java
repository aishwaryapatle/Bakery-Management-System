package BMS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Product_Type_Frame {

	public static void Product_Type_Frame_Code()
	{
		JFrame frame3 = new JFrame("Add Product Type");
		JOptionPane pane = new JOptionPane();
		
		
		PanelButton.PanelButtonCode(frame3,1);
		
		JLabel label = new JLabel("Add Product Type");
		label.setBounds(780,50,250,50);
		label.setFont(new Font("Times New Roman", Font.BOLD,30));

		
		JLabel ptype = new JLabel("Product Type Title");
		ptype.setBounds(700,180,250,26);
		ptype.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField ptypeText = new JTextField();
		ptypeText.setBounds(700,220,400,40);
		ptypeText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JLabel desc = new JLabel("Description");
		desc.setBounds(700,300,150,26);
		desc.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField descText = new JTextField();
		descText.setBounds(700,340,400,100);
		descText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JButton add = new JButton("Save Product");
		add.setBounds(800, 480, 180, 32);
		add.setFont(new Font("Times New Roman", Font.PLAIN,23));
		
		
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Product_Type p = new Product_Type(ptypeText.getText(), descText.getText());
				
				try{
					int x = Product_Type_Connectivity.Product_Type_Connectivity_Code(p);
					if(x>0)
					{
						pane.showMessageDialog(frame3, "Product type saved successfully");
						ptypeText.setText(null);
						descText.setText(null);
					}
					else
					{
						pane.showMessageDialog(frame3, "Not saved successfully");
						ptypeText.setText(null);
						descText.setText(null);
					}
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		JPanel panel = new JPanel();
		JLabel img = new JLabel(new ImageIcon("D:/Project/Images/Bakery6.1 (1).png"));
		panel.add(img);
		panel.setBounds(718, 8, 1202, 800);
		panel.setBackground(new Color(250,225,227));
		
		
		frame3.setLayout(new FlowLayout());
		frame3.getContentPane().setBackground(new Color(250,225,227));
		
		frame3.add(label);
		frame3.add(ptype);
		frame3.add(ptypeText);
		frame3.add(desc);
		frame3.add(descText);
		frame3.add(add);
		frame3.add(panel);
		
		
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame3.setLayout(null);
		frame3.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame3.setUndecorated(true);
		frame3.setVisible(true);
		
	}
}
