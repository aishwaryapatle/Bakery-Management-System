package BMS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Try {

	private static JFrame frame5;
	private static JTextField txtID;
	private static JTextField txtPtype;
	private static JTextField txtPname;
	private static JTextField txtPrice;
	public static JTable table;
	public static JTable table1;
	public static String data;
	public static int price;
	public static JTextField cidText;
	public static int b;

	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Connection conn;
	
	public static void Trying_Code()
	{
		initialize();
		try {
			conn = Connective.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		showTable();
		showTable1();
	}

	public static ArrayList<Add_Product> getArrayList(){
		ArrayList <Add_Product> list  = new ArrayList();
		try {
			stmt = conn.prepareStatement("Select * From bakery.addProduct");
			rs = stmt.executeQuery();
			while(rs.next()){
				Add_Product user = new Add_Product(rs.getInt("id"),rs.getString("pname"),rs.getString("pptype"),rs.getInt("pprice"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static void showTable(){
		ArrayList<Add_Product> list = getArrayList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] cols = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			cols[0] = list.get(i).getId();
			cols[1] = list.get(i).getPname();
			cols[2] = list.get(i).getPptype();
			cols[3] = list.get(i).getPprice();
			model.addRow(cols);
		}
	}
	
	
	public static ArrayList<Add_Sells> getArrayList1(){
		ArrayList <Add_Sells> list1  = new ArrayList();
		try {
			stmt = conn.prepareStatement("Select * From bakery.addSells2 where customerid = ?");
			stmt.setInt(1, b);
			rs = stmt.executeQuery();
			while(rs.next()){
				Add_Sells user = new Add_Sells(rs.getInt("orderid"),rs.getString("item"),rs.getInt("cost"),rs.getInt("quantity"),rs.getDouble("totalcost"));
				list1.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list1;
	}
	
	public static void showTable1(){
		ArrayList<Add_Sells> list1 = getArrayList1();
		DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
		Object[] cols1 = new Object[5];
		for (int i = 0; i < list1.size(); i++) {
			cols1[0] = list1.get(i).getOrderid();
			cols1[1] = list1.get(i).getItem();
			cols1[2] = list1.get(i).getCost();
			cols1[3] = list1.get(i).getQuantity();
			cols1[4] = list1.get(i).getTotalcost();
			model1.addRow(cols1);
		}
	}

//	public static void queryUpdate(String sql,String message){
//		try {
//			stmt = conn.prepareStatement(sql);
//			if(stmt.executeUpdate()==1){
//				DefaultTableModel model = (DefaultTableModel)table.getModel();
//				model.setRowCount(0);
//				showTable();
//				JOptionPane.showMessageDialog(null, message + " Successfully!");
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//		}
//	}
	public static void queryUpdate1(String sql,String message){
		try {
			stmt = conn.prepareStatement(sql);
			if(stmt.executeUpdate()==1){
				DefaultTableModel model = (DefaultTableModel)table1.getModel();
				model.setRowCount(0);
				showTable1();
				JOptionPane.showMessageDialog(null, message + " Successfully!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		frame5 = new JFrame();
		frame5.setTitle("Person Table\r\n");
		frame5.setBounds(100, 100, 450, 300);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);

		
		JLabel cid = new JLabel("Customer ID");
		cid.setBounds(550,180,300,26);
		cid.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(cid);
		
		cidText = new JTextField();
		cidText.setBounds(550,215,400,35);
		cidText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(cidText);
		
		
		JLabel selectProductlbl = new JLabel("Select Product");
		selectProductlbl.setBounds(550,400,300,26);
		selectProductlbl.setFont(new Font("Times New Roman", Font.PLAIN,20));
		selectProductlbl.setVisible(false);
		frame5.add(selectProductlbl);
		
		
		
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(850,400,100,26);
		quantity.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		quantity.setVisible(false);
		frame5.add(quantity);
		
		
		JTextField quantityText = new JTextField();
		quantityText.setBounds(850,445,160,35);
		quantityText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(quantityText);
		
		
		JLabel cost = new JLabel("Cost");
		cost.setBounds(1050,400,300,26);
		cost.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		quantity.setVisible(false);
		frame5.add(cost);
		
		
		JTextField costText = new JTextField();
		costText.setBounds(1050,445,160,35);
		costText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		costText.setEditable(false);
		frame5.add(costText);
		
		
		
		
		txtID = new JTextField();
		txtID.setBounds(137, 13, 127, 20);
		txtID.setEditable(false);
		frame5.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtPname = new JTextField();
		txtPname.setColumns(10);
		txtPname.setEditable(false);
		txtPname.setBounds(137, 44, 127, 20);
		frame5.getContentPane().add(txtPname);

		txtPtype = new JTextField();
		txtPtype.setColumns(10);
		txtPtype.setEditable(false);
		txtPtype.setBounds(137, 80, 127, 20);
		frame5.getContentPane().add(txtPtype);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(137, 104, 127, 20);
		txtPrice.setEditable(false);
		frame5.getContentPane().add(txtPrice);

		

		JButton btnInser = new JButton("Insert");
		//  btnInser.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\add-icon.png"));
		btnInser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b = Integer.parseInt(cidText.getText());
				double totalcost = Integer.parseInt(txtPrice.getText())*Integer.parseInt(quantityText.getText());
				String sql ="INSERT INTO bakery.addSells2 (customerid, item, cost, quantity, totalcost) "
						+ "VALUES ("+Integer.parseInt(cidText.getText())+", '"+txtPname.getText()+"', "+Integer.parseInt(txtPrice.getText())+", "+Integer.parseInt(quantityText.getText())+", "+totalcost+")";
				queryUpdate1(sql,"Insert");
			}
		});

		btnInser.setBounds(309, 10, 98, 23);
		frame5.getContentPane().add(btnInser);

//		
//
//		JButton btnDelete = new JButton("Delete");
//		//  btnDelete.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Actions-edit-delete-icon.png"));
//		btnDelete.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String sql = "DELETE FROM bakery.ProductType WHERE id='"+txtID.getText()+"'";
//				queryUpdate(sql, "Delete");
//			}
//		});
//
//		btnDelete.setBounds(309, 111, 98, 23);
//		frame5.getContentPane().add(btnDelete);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 414, 108);
		frame5.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				TableModel model = (TableModel)table.getModel();
				txtID.setText(model.getValueAt(row, 0).toString());
				txtPname.setText(model.getValueAt(row, 1).toString());
				txtPtype.setText(model.getValueAt(row, 2).toString());
				txtPrice.setText(model.getValueAt(row, 3).toString());

			}
		});

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"id", "Product Name", "Product Type", "Price"
				}
				));
		scrollPane.setViewportView(table);
		
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(500, 300, 414, 108);
		frame5.getContentPane().add(scrollPane1);

		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table1.getSelectedRow();
				TableModel model = (TableModel)table1.getModel();
				txtID.setText(model.getValueAt(row, 0).toString());
				txtPname.setText(model.getValueAt(row, 1).toString());
//				txtPtype.setText(model.getValueAt(row, 2).toString());
				txtPrice.setText(model.getValueAt(row, 2).toString());

			}
		});

		table1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"orderid", "Items", "Price", "Quantity", "TotalCost"
				}
				));
		scrollPane1.setViewportView(table1);
		
		

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 14, 76, 14);
		frame5.getContentPane().add(lblId);

		JLabel lblPname = new JLabel("Pname");
		lblPname.setBounds(29, 45, 76, 14);
		frame5.getContentPane().add(lblPname);

		JLabel lblPtype = new JLabel("Ptype");
		lblPtype.setBounds(29, 81, 76, 14);
		frame5.getContentPane().add(lblPtype);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(29, 104, 76, 14);
		frame5.getContentPane().add(lblPrice);
		
		
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setLayout(null);
		frame5.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame5.setVisible(true);

	}
}
