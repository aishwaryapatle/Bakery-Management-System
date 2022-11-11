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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class Add_Sells_Frame {

	static String data;
	static int price;
	private static JTextField costText;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Connection conn;
	public static JTable table1 = new JTable();

	public static void Add_Sells_Frame_Code() {
		
		initialize1();
		showTable1();
	}
	
	private static void initialize1() {

		JFrame frame7 = new JFrame("Add Product");
		JOptionPane pane = new JOptionPane();
		
		PanelButton.PanelButtonCode(frame7, 1);
		
		JLabel label = new JLabel("Product Billing Dashboard");
		label.setBounds(800,50,400,50);
		label.setFont(new Font("Times New Roman", Font.BOLD,30));
		frame7.add(label);
	
		
		JLabel orderid = new JLabel("Order ID");
		orderid.setBounds(550,180,300,26);
		orderid.setFont(new Font("Times New Roman", Font.PLAIN,20));
		orderid.setVisible(false);
		frame7.add(orderid);
		
		
		JTextField cidText = new JTextField();
		cidText.setBounds(550,215,400,35);
		cidText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		cidText.setVisible(false);
		cidText.setEditable(false);
		frame7.add(cidText);
		
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		JFormattedTextField today = new JFormattedTextField(dateFormat);
		today.setName("Today");
		today.setFont(new Font("Times New Roman", Font.PLAIN,20));
		today.setColumns(10);
		today.setEditable(false);
		today.setVisible(false);
		today.setBounds(1000,215,400,35);
		frame7.add(today);
		
		
		JLabel todayLabel = new JLabel("Order Date");
		todayLabel.setLabelFor(today);
		todayLabel.setFont(new Font("Times New Roman", Font.PLAIN,20));
		today.setValue(new Date());
		todayLabel.setBounds(1000,180,300,26);
		todayLabel.setVisible(false);
		frame7.add(todayLabel);
				
		
		JLabel cname = new JLabel("Customer Name");
		cname.setBounds(550,180,300,26);
		cname.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(cname);
		
		
		JTextField cnameText = new JTextField();
		cnameText.setBounds(550,215,400,35);
		cnameText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(cnameText);
		
		
		JLabel cnum = new JLabel("Contact Number");
		cnum.setBounds(1000,180,300,26);
		cnum.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(cnum);
		
		
		JTextField cnumText = new JTextField();
		cnumText.setBounds(1000,215,400,35);
		cnumText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(cnumText);
	
		
		JLabel selectProductlbl = new JLabel("Select Product");
		selectProductlbl.setBounds(550,400,300,26);
		selectProductlbl.setFont(new Font("Times New Roman", Font.PLAIN,20));
		selectProductlbl.setVisible(false);
		frame7.add(selectProductlbl);
		
		
		JComboBox pptypeText = new JComboBox();
		pptypeText.setBounds(550,445,250,35);
		pptypeText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(pptypeText);
		
		Connection con;
		try {
			con = Connective.getConnection();
			Statement st = con.createStatement();
			String s = "SELECT * from bakery.addProduct";
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
				Statement st;
				try {
					conn = Connective.getConnection();
					st = conn.createStatement();
					String s = "SELECT addProduct.pprice FROM bakery.addProduct INNER JOIN bakery.ProductType ON addProduct.pptype = ProductType.ptype WHERE addProduct.pname = '"+data+"';";
					ResultSet rs = st.executeQuery(s);
					
					while(rs.next())
					{
						price = rs.getInt("pprice");
						costText.setText(Integer.toString(price));
					}
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(850,400,100,26);
		quantity.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		quantity.setVisible(false);
		frame7.add(quantity);
		
		
		JTextField quantityText = new JTextField();
		quantityText.setBounds(850,445,160,35);
		quantityText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(quantityText);
		
		
		JLabel cost = new JLabel("Cost");
		cost.setBounds(1050,400,300,26);
		cost.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		quantity.setVisible(false);
		frame7.add(cost);
		
		
		costText = new JTextField();
		costText.setBounds(1050,445,160,35);
		costText.setFont(new Font("Times New Roman", Font.PLAIN,20));
		costText.setEditable(false);
		frame7.add(costText);
		
		
		
		
		
		
		
		
		JButton addToCart = new JButton("Add to Cart");
		addToCart.setBounds(1250, 445, 150, 35);
		addToCart.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(addToCart);
		
		JButton register = new JButton("register");
		register.setBounds(1250, 500, 150, 35);
		register.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(register);
		
		
		JLabel allCartItems = new JLabel("All Cart Items");
		allCartItems.setBounds(550,550,300,26);
		allCartItems.setFont(new Font("Times New Roman", Font.PLAIN,20));
//		allCartItems.setVisible(false);
		frame7.add(allCartItems);
		
		
		JButton saveAndPrint = new JButton("Save and Print");
		saveAndPrint.setBounds(1250, 900, 150, 35);
		saveAndPrint.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(saveAndPrint);
		
		
		JButton startBilling = new JButton("Start Billing");
		startBilling.setBounds(550, 300, 180, 32);
		startBilling.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame7.add(startBilling);
		
		
		startBilling.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(!(cnameText.getText().isEmpty() && cnumText.getText().isEmpty()))
//				{
					orderid.setVisible(true);
					cidText.setVisible(true);
					today.setVisible(true);
					todayLabel.setVisible(true);
					startBilling.setVisible(false);
					cname.setBounds(550,280,300,26);
					cnameText.setBounds(550,315,400,35);
					cnum.setBounds(1000,280,300,26);
					cnumText.setBounds(1000,315,400,35);
					try {
						conn = Connective.getConnection();
						stmt = conn.prepareStatement("SELECT * FROM bakery.addSells1");
						ResultSet rs = stmt.executeQuery();
						while(rs.next()){
							int a = (rs.getInt(1))+1;
							String b = Integer.toString(a);
							cidText.setText(b);
						}

					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					selectProductlbl.setVisible(true);
				}
		});
		
		
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String text = today.getText();
				try {
					conn = Connective.getConnection();
					Statement st = conn.createStatement();
					String sql ="INSERT INTO bakery.addSells1 (customername, customercontact, date1) VALUES ('"+cnameText.getText()+"', '"+cnumText.getText()+"', '"+text+"')";
					int x = st.executeUpdate(sql);
					if(x>0)
					{
						JOptionPane.showMessageDialog(frame7, "Product type saved successfully");
						conn.close();
					}
					else
					{
						JOptionPane.showMessageDialog(frame7, "Not saved successfully");
						conn.close();
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		addToCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sql ="INSERT INTO bakery.addSells (customerid, item, cost, quantity, totalcost) VALUES ("+cidText.getText()+", '"+data+"', "+costText.getText()+", "+quantityText.getText()+", "+23+")";
				queryUpdate(sql,"Insert");
			}
		});

		
		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table1.getSelectedRow();
				TableModel model = (TableModel)table1.getModel();
//				txtID.setText(model.getValueAt(row, 0).toString());
//				txtPtype.setText(model.getValueAt(row, 1).toString());
//				txtDesc.setText(model.getValueAt(row, 2).toString());

			}
		});

		table1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Order Id", "Item", "Cost Per Unit", "Quantity", "Total Cost"
				}
				));
		
		
		table1.setRowHeight(30);
		table1.setBackground(Color.WHITE);
		table1.setFont(new Font("Times New Roman", Font.PLAIN,20));

		JTableHeader tableHeader = table1.getTableHeader();
		tableHeader.setBackground(new Color(192,192,192));
		tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(550, 600, 850, 200);
		frame7.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table1);		
		
		
		
		
		JPanel panel = new JPanel();
		JLabel img = new JLabel(new ImageIcon("D:/Project/Images/Bakery6.1 (1).png"));
		panel.add(img);
		panel.setBounds(718, 8, 1202, 800);
		panel.setBackground(new Color(250,225,227));
		frame7.add(panel);
		
		
		frame7.setLayout(new FlowLayout());
		frame7.getContentPane().setBackground(new Color(250,225,227));		
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.setLayout(null);
		frame7.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame7.setVisible(true);
	}
	
	//where clause
	public static ArrayList<Add_Sells> getArrayList(){
		ArrayList <Add_Sells> list  = new ArrayList();
		try {
			stmt = conn.prepareStatement("SELECT addSells1.customerid, addSells2.orderid, addSells1.customername, addsells1.customercontact, addsells1.date1, addSells2.item, addSells2.cost, addSells2.quantity, addSells2.totalcost FROM bakery.addSells1 INNER JOIN bakery.addSells2 ON addSells1.orderid = addSells2.orderid;");
			rs = stmt.executeQuery();
			while(rs.next()){
				Add_Sells user = new Add_Sells(rs.getInt("customerid"), rs.getInt("orderid"), rs.getString("customername"), rs.getString("customercontact"), rs.getString("date1"), rs.getString("item"), rs.getDouble("cost"), rs.getInt("quantity"), rs.getDouble("totalcost"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static void showTable1(){
		ArrayList<Add_Sells> list = getArrayList();
		DefaultTableModel model = (DefaultTableModel)table1.getModel();
		Object[] cols = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			cols[0] = list.get(i).getOrderid();
			cols[1] = list.get(i).getItem();
			cols[2] = list.get(i).getCost();
			cols[3] = list.get(i).getQuantity();
			cols[4] = list.get(i).getTotalcost();
			model.addRow(cols);
		}
	}

	public static void queryUpdate(String sql,String message){
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


