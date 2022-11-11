package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelButton {

	public static void PanelButtonCode(JFrame frame2, int a) {

		JPanel panel1 = new JPanel(new GridLayout(8, 1, 5, 40));

		JLabel menu = new JLabel("MENU", SwingConstants.CENTER);
		menu.setForeground(Color.BLACK);
		menu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel1.add(menu);

		JButton addProduct = new JButton("Add Product");
		addProduct.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel1.add(addProduct);

		JButton addProductType = new JButton("Add Product Type");
		addProductType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel1.add(addProductType);

		JButton addSells = new JButton("Add Sells");
		addSells.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel1.add(addSells);

		JButton productReport = new JButton("Product Report");
		productReport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel1.add(productReport);

		JButton productTypeReport = new JButton("Product Type Report");
		productTypeReport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel1.add(productTypeReport);

		JButton sellsReport = new JButton("Sells Report");
		sellsReport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel1.add(sellsReport);

		JButton back = new JButton("Back to Home");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		if (a == 0) {
			panel1.add(exit);
		} else if (a == 1) {
			panel1.add(back);
		}

		panel1.setBounds(80, 150, 300, 700);
		panel1.setBackground(new Color(0, 0, 0, 0));
		frame2.add(panel1);

		addProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame2.dispose();
				Add_Product_Frame.Add_Product_Frame_Code();
			}
		});

		addProductType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame2.dispose();
				Product_Type_Frame.Product_Type_Frame_Code();
			}
		});

		productReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					frame2.dispose();
					Add_Product_Report_Frame.Add_Product_Report_Frame_Code();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		productTypeReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame2.dispose();
				try {
					Product_Type_Report_Frame.Product_Type_Report_Frame_Code();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		addSells.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame2.dispose();
				Trying.Trying_Code();
			}
		});

		sellsReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame2.dispose();
				try {
					Add_Sells_Report_Frame.Add_Sells_Report_Frame_Code();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Home.Home_Code();
				frame2.dispose();
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame2.dispose();
			}
		});

	}
}
