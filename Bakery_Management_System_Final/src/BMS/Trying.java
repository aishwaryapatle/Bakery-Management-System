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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.lang.model.element.QualifiedNameable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class Trying {

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


	/*
	 * Initialize the contents of the frame.
	 */
	private static void initialize() 
	{
		frame5 = new JFrame();
		frame5.setTitle("Add Sells");

		JOptionPane pane = new JOptionPane();
		
		PanelButton.PanelButtonCode(frame5, 1);
		
		JLabel label = new JLabel("Product Billing Dashboard");
		label.setBounds(800,50,400,50);
		label.setFont(new Font("Times New Roman", Font.BOLD,30));
		frame5.add(label);
	
		
		JLabel cid = new JLabel("Customer ID");
		cid.setBounds(550,180,280,26);
		cid.setFont(new Font("Times New Roman", Font.PLAIN,20));
		cid.setVisible(false);
		frame5.add(cid);
		
		
		JTextField cidText = new JTextField();
		cidText.setBounds(550,215,360,35);
		cidText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		cidText.setVisible(false);
//		cidText.setEditable(false);
		frame5.add(cidText);
		
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		JFormattedTextField today = new JFormattedTextField(dateFormat);
		today.setFont(new Font("Times New Roman", Font.PLAIN,20));
		today.setColumns(10);
		today.setEditable(false);
		today.setVisible(false);
		today.setBounds(980,215,360,35);
		frame5.add(today);
		
		
		JLabel todayLabel = new JLabel("Order Date");
		todayLabel.setLabelFor(today);
		todayLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
		today.setValue(new Date());
		todayLabel.setBounds(980,180,280,26);
		todayLabel.setVisible(false);
		frame5.add(todayLabel);
				
		
		JLabel cname = new JLabel("Customer Name");
		cname.setBounds(550,180,280,26);
		cname.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(cname);
		
		
		JTextField cnameText = new JTextField();
		cnameText.setBounds(550,215,360,35);
		cnameText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(cnameText);
		
		
		JLabel cnum = new JLabel("Contact Number");
		cnum.setBounds(980,180,280,26);
		cnum.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(cnum);
		
		
		JTextField cnumText = new JTextField();
		cnumText.setBounds(980,215,360,35);
		cnumText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(cnumText);
	
		
		
		
		//Right side
		JLabel selectProductlbl = new JLabel("Select Product");
		selectProductlbl.setBounds(1620,80,300,26);
		selectProductlbl.setFont(new Font("Times New Roman", Font.BOLD,22));
//		selectProductlbl.setVisible(false);
		frame5.add(selectProductlbl);
		
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(1550,650,100,26);
		quantity.setFont(new Font("Times New Roman", Font.PLAIN,22));
//		quantity.setVisible(false);
		frame5.add(quantity);
		
		
		JTextField quantityText = new JTextField();
		quantityText.setBounds(1700,650,160,35);
		quantityText.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		quantityText.setVisible(false);
		frame5.add(quantityText);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(1550, 150, 100, 26);
		lblId.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		lblId.setVisible(false);
		frame5.getContentPane().add(lblId);
		

		JLabel lblPname = new JLabel("Product Name");
		lblPname.setBounds(1550, 210, 150, 26);
//		lblPname.setVisible(false);
		lblPname.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(lblPname);

		
		JLabel lblPtype = new JLabel("Product Type");
		lblPtype.setBounds(1550, 270, 150, 26);
//		lblPtype.setVisible(false);
		lblPtype.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(lblPtype);
		
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(1550, 330, 100, 26);
//		lblPrice.setVisible(false);
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(lblPrice);
		
		
		txtID = new JTextField();
		txtID.setBounds(1700, 150, 150, 35);
		txtID.setFont(new Font("Times New Roman", Font.PLAIN,20));
		txtID.setEditable(false);
		frame5.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtPname = new JTextField();
		txtPname.setColumns(10);
		txtPname.setFont(new Font("Times New Roman", Font.PLAIN,20));
		txtPname.setEditable(false);
		txtPname.setBounds(1700, 210, 150, 35);
		frame5.getContentPane().add(txtPname);

		txtPtype = new JTextField();
		txtPtype.setColumns(10);
		txtPtype.setFont(new Font("Times New Roman", Font.PLAIN,20));
		txtPtype.setEditable(false);
		txtPtype.setBounds(1700, 270, 150, 35);
		frame5.getContentPane().add(txtPtype);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN,20));
		txtPrice.setBounds(1700, 330, 150, 35);
		txtPrice.setEditable(false);
		frame5.getContentPane().add(txtPrice);

		
		JButton startBilling = new JButton("Start Billing");
		startBilling.setBounds(550, 300, 180, 32);
		startBilling.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.add(startBilling);
		
		JLabel allCartItems = new JLabel("All Cart Items");
		allCartItems.setBounds(550,400,300,26);
		allCartItems.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		allCartItems.setVisible(false);
		frame5.add(allCartItems);
		
		
		startBilling.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(!(cnameText.getText().isEmpty() && cnumText.getText().isEmpty()))
				{
					cid.setVisible(true);
					cidText.setVisible(true);
					today.setVisible(true);
					todayLabel.setVisible(true);
					startBilling.setVisible(false);
					cname.setBounds(550,280,280,26);
					cnameText.setBounds(550,315,360,35);
					cnum.setBounds(980,280,300,26);
					cnumText.setBounds(980,315,360,35);
					
					
					
					try {
						conn = Connective.getConnection();
						stmt = conn.prepareStatement("SELECT * FROM bakery.addSells1");
						ResultSet rs = stmt.executeQuery();
						while(rs.next()){
							int a = (rs.getInt(1))+1;
							String b = Integer.toString(a);
							cidText.setText(b);
						}
						
						String sql ="INSERT INTO bakery.addSells1 (customerid, customername, customercontact, date1)"
								+ "VALUES ("+Integer.parseInt(cidText.getText())+", '"+cnameText.getText()+"', '"+cnumText.getText()+"', '"+today.getText().toString()+"')";
						queryUpdate1(sql,"Insert");

					
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		
		JButton addToCart = new JButton("Add To Cart");
		addToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b = Integer.parseInt(cidText.getText());
				double totalcost = Integer.parseInt(txtPrice.getText())*Integer.parseInt(quantityText.getText());
				String sql ="INSERT INTO bakery.addSells2 (customerid, item, cost, quantity, totalcost) "
						+ "VALUES ("+Integer.parseInt(cidText.getText())+", '"+txtPname.getText()+"', "+Integer.parseInt(txtPrice.getText())+", "+Integer.parseInt(quantityText.getText())+", "+totalcost+")";
				queryUpdate1(sql,"Insert");
			}
		});

		addToCart.setBounds(1600, 750, 180, 35);
		addToCart.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		frame5.getContentPane().add(addToCart);
		
		
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM bakery.addSells2 WHERE orderid='"+txtID.getText()+"'";
				queryUpdate1(sql, "Deleted");
				
			}
		});

		delete.setBounds(550,620,170,35);
		delete.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(delete);

		
		JButton print = new JButton("Save and Print");
		print.setBounds(1160,620,170,35);
		print.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(print);
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1480, 400, 400, 200);
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
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);

		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN,20));

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(192,192,192));
		tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(550, 450, 780, 150);
		frame5.getContentPane().add(scrollPane1);

		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table1.getSelectedRow();
				TableModel model = (TableModel)table1.getModel();
				txtID.setText(model.getValueAt(row, 0).toString());
				txtPname.setText(model.getValueAt(row, 1).toString());
				txtPrice.setText(model.getValueAt(row, 3).toString());

			}
		});

		table1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Orderid", "Items", "Cost per Unit", "Quantity", "TotalCost"
				}
				));
		scrollPane1.setViewportView(table1);
		table1.setRowHeight(30);

		table1.setBackground(Color.WHITE);
		table1.setFont(new Font("Times New Roman", Font.PLAIN,20));

		JTableHeader tableHeader1 = table1.getTableHeader();
		tableHeader1.setBackground(new Color(192,192,192));
		tableHeader1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setLayout(null);
		frame5.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame5.setVisible(true);

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
}
