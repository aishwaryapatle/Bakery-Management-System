package BMS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;

public class Add_Product_Frame {
	
	static String data;
	public static void Add_Product_Frame_Code() {

		JFrame frame4 = new JFrame("Add Product");
		JOptionPane pane = new JOptionPane();
		
		
		JLabel label = new JLabel("Add Product");
		label.setBounds(880,50,250,50);
		label.setFont(new Font("Times New Roman", Font.BOLD,30));
	
		
		JLabel pname = new JLabel("Product Name");
		pname.setBounds(800,180,250,26);
		pname.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField pnameText = new JTextField();
		pnameText.setBounds(800,215,400,35);
		pnameText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JLabel modalno = new JLabel("Model No.");
		modalno.setBounds(800,280,250,26);
		modalno.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField modalnoText = new JTextField();
		modalnoText.setBounds(800,315,400,35);
		modalnoText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JLabel pptype = new JLabel("Select Product Type");
		pptype.setBounds(800,390,250,26);
		pptype.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
//		JTextField pptypeText = new JTextField();
//		pptypeText.setBounds(800,425,400,35);
//		pptypeText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JComboBox pptypeText = new JComboBox();
		pptypeText.setBounds(800,425,400,35);
		pptypeText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		Connection con;
		try {
			con = Connective.getConnection();
			Statement st = con.createStatement();
			String s = "SELECT * from bakery.ProductType";
			ResultSet rs = st.executeQuery(s);
			
			while(rs.next())
			{
				pptypeText.addItem(rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		pptypeText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				data = pptypeText.getSelectedItem().toString();
			}
		});
		
		
		JLabel pprice = new JLabel("Product Price");
		pprice.setBounds(800,500,250,26);
		pprice.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField ppriceText = new JTextField();
		ppriceText.setBounds(800,535,400,35);
		ppriceText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JLabel pstock = new JLabel("No. of Stock");
		pstock.setBounds(800,610,250,26);
		pstock.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField pstockText = new JTextField();
		pstockText.setBounds(800,645,400,35);
		pstockText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		JLabel desc = new JLabel("Description");
		desc.setBounds(800,720,150,26);
		desc.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JTextField descText = new JTextField();
		descText.setBounds(800,755,400,100);
		descText.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		
		JButton add1 = new JButton("Save Product");
		add1.setBounds(900, 890, 180, 32);
		add1.setFont(new Font("Times New Roman", Font.PLAIN,23));
		
		
		PanelButton.PanelButtonCode(frame4, 1);
		
		add1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Add_Product a = new Add_Product(pnameText.getText(), Integer.parseInt(modalnoText.getText()), data, Integer.parseInt(ppriceText.getText()), Integer.parseInt(pstockText.getText()), descText.getText());
				
				try{
					int x = Add_Product_Connectivity.Add_Product_Connectivity_Code(a);
					if(x>0)
					{
						pane.showMessageDialog(frame4, "Product type saved successfully");
					}
					else
					{
						pane.showMessageDialog(frame4, "Not saved successfully");
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
		
		
		frame4.setLayout(new FlowLayout());
		
	//	rgba(205,225,156,255)
	//	rgba(250,225,227,255)
		
		frame4.getContentPane().setBackground(new Color(250,225,227));
		
		frame4.add(label);
		frame4.add(pname);
		frame4.add(pnameText);
		frame4.add(modalno);
		frame4.add(modalnoText);
		frame4.add(pptype);
		frame4.add(pptypeText);
		frame4.add(pprice);
		frame4.add(ppriceText);
		frame4.add(pstock);
		frame4.add(pstockText);
		frame4.add(desc);
		frame4.add(descText);
		frame4.add(add1);
		frame4.add(panel);
		
		
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame4.setLayout(null);
		frame4.setExtendedState(JFrame.MAXIMIZED_BOTH);
	//	frame4.setUndecorated(true);
		frame4.setVisible(true);
	}

}