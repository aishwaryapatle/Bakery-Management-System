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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class Add_Product_Report_Frame {

	private static JFrame frame6;
	private static JTextField pidTextReport;
	private static JTextField pnameTextReport;
	private static JTextField ppriceTextReport;
	private static JTextField modalnoTextReport;
	private static JTextField pstockTextReport;
	private static JTextField descTextReport;
	private static JTextField pptypeTextReport;
	static String data;
	
	public static JTable table = new JTable();

	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Connection conn;

	public static void Add_Product_Report_Frame_Code() throws ClassNotFoundException, SQLException
	{
		initialize();
		showTable();
	}
	
	private static void initialize() {
		
		frame6 = new JFrame("Product Report");
		frame6.setBounds(100, 100, 450, 300);

		PanelButton.PanelButtonCode(frame6,1);
		
		JLabel heading = new JLabel("Product Report");
		heading.setBounds(825,50,650,50);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Times New Roman", Font.BOLD,32));
		frame6.add(heading);
		
		JLabel pidReport = new JLabel("ID");
		pidReport.setBounds(600,460,200,35);
		pidReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(pidReport);
		
		
		pidTextReport = new JTextField();
		pidTextReport.setBounds(850,460,400,35);
		pidTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		pidTextReport.setEditable(false);
		frame6.getContentPane().add(pidTextReport);
		
		
		JLabel pnameReport = new JLabel("Product Name");
		pnameReport.setBounds(600,510,200,35);
		pnameReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(pnameReport);
		
		
		pnameTextReport = new JTextField();
		pnameTextReport.setBounds(850,510,400,35);
		pnameTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(pnameTextReport);
		
		
		JLabel modalnoReport = new JLabel("Model No.");
		modalnoReport.setBounds(600,560,200,35);
		modalnoReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(modalnoReport);
		
		
		modalnoTextReport = new JTextField();
		modalnoTextReport.setBounds(850,560,400,35);
		modalnoTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(modalnoTextReport);
		
		
		JLabel pptypeReport = new JLabel("Select Product Type");
		pptypeReport.setBounds(600,610,200,35);
		pptypeReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(pptypeReport);
		
		
		pptypeTextReport = new JTextField();
		pptypeTextReport.setBounds(850,610,200,35);
		pptypeTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(pptypeTextReport);
		
		
		JComboBox cb = new JComboBox();
		cb.setBounds(1060,610,200,35);
		cb.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(cb);
		
		Connection con;
		try {
			con = Connective.getConnection();
			Statement st = con.createStatement();
			String s = "SELECT * from bakery.ProductType";
			ResultSet rs = st.executeQuery(s);
			cb.addItem("Select");
			
			while(rs.next())
			{
				cb.addItem(rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				data = cb.getSelectedItem().toString();
				if(!data.equals("Select"))
				{
					pptypeTextReport.setText(data);
				}
			}
		});
		
		
		
		JLabel ppriceReport = new JLabel("Product Price");
		ppriceReport.setBounds(600,660,200,35);
		ppriceReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(ppriceReport);
	
		
		ppriceTextReport = new JTextField();
		ppriceTextReport.setBounds(850,660,400,35);
		ppriceTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(ppriceTextReport);
		
		
		JLabel pstockReport = new JLabel("No. of Stock");
		pstockReport.setBounds(600,710,200,35);
		pstockReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(pstockReport);
		
		
		pstockTextReport = new JTextField();
		pstockTextReport.setBounds(850,710,400,35);
		pstockTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(pstockTextReport);
		
		
		JLabel descReport = new JLabel("Description");
		descReport.setBounds(600,760,200,35);
		descReport.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame6.getContentPane().add(descReport);
		
		
		descTextReport = new JTextField();
		descTextReport.setBounds(850,760,400,100);
		descTextReport.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(descTextReport);
		
		
		
		
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="UPDATE bakery.addProduct SET pname='"+pnameTextReport.getText()+"', modelno='"+Integer.parseInt(modalnoTextReport.getText())+"', "
						+ "pptype='"+pptypeTextReport.getText()+"', pprice='"+Integer.parseInt(ppriceTextReport.getText())+"', "
						+ "pstock='"+Integer.parseInt(pstockTextReport.getText())+"', pdescription='"+descTextReport.getText()+"' WHERE id='"+Integer.parseInt(pidTextReport.getText())+"'";
				try {
					queryUpdate(sql, "Updated");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		update.setBounds(850,880,170,35);
		update.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(update);

		
		JButton delete = new JButton("Delete");
		//  btnDelete.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Actions-edit-delete-icon.png"));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM bakery.addProduct WHERE id='"+Integer.parseInt(pidTextReport.getText())+"'";
				try {
					queryUpdate(sql, "Deleted");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		delete.setBounds(1080,880,170,35);
		delete.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame6.getContentPane().add(delete);


		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				TableModel model = (TableModel)table.getModel();
				pidTextReport.setText(model.getValueAt(row, 0).toString());
				pnameTextReport.setText(model.getValueAt(row, 1).toString());
				modalnoTextReport.setText(model.getValueAt(row, 2).toString());
				pptypeTextReport.setText(model.getValueAt(row, 3).toString());
				ppriceTextReport.setText(model.getValueAt(row, 4).toString());
				pstockTextReport.setText(model.getValueAt(row, 5).toString());
				descTextReport.setText(model.getValueAt(row, 6).toString());

			}
		});
		

		table.setModel(new DefaultTableModel(
			new Object[][] {}, new String[] {"ID", "Product Name", "Model No.", "Product Type", "Price", "Stock", "Description"}
		));
		
		table.setRowHeight(30);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN,20));

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(192,192,192));
		tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 150, 900, 250);
		frame6.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		
		
		JPanel panel = new JPanel();
		JLabel img = new JLabel(new ImageIcon("D:/Project/Images/Bakery6.1 (1).png"));
		panel.add(img);
		panel.setBounds(718, 8, 1202, 800);
		panel.setBackground(new Color(250,225,227));
		frame6.add(panel);
		
		
		frame6.setLayout(new FlowLayout());
		frame6.getContentPane().setBackground(new Color(250,225,227));
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setLayout(null);
		frame6.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame6.setVisible(true);

	}
	
	
	
	public static ArrayList<Add_Product> getArrayList(){
		ArrayList <Add_Product> list  = new ArrayList();
		try {
			conn = Connective.getConnection();
			stmt = conn.prepareStatement("Select * From bakery.addProduct");
			rs = stmt.executeQuery();
			while(rs.next()){
				Add_Product user = new Add_Product(rs.getInt("id"),rs.getString("pname"),rs.getInt("modelno"),rs.getString("pptype"),rs.getInt("pprice"),rs.getInt("pstock"),rs.getString("pdescription"));
				list.add(user);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void showTable(){
		ArrayList <Add_Product> list = getArrayList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] cols = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			cols[0] = list.get(i).getId();
			cols[1] = list.get(i).getPname();
			cols[2] = list.get(i).getModelno();
			cols[3] = list.get(i).getPptype();
			cols[4] = list.get(i).getPprice();
			cols[5] = list.get(i).getPstock();
			cols[6] = list.get(i).getPdescription();

			model.addRow(cols);
		}
	}

	public static void queryUpdate(String sql,String message) throws ClassNotFoundException{
		try {
			conn = Connective.getConnection();
			stmt = conn.prepareStatement(sql);
			if(stmt.executeUpdate()==1){
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				showTable();
				JOptionPane.showMessageDialog(null, message + " Successfully!");
				makingNull();
				conn.close();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Not "+ message + " Successfully!");
				makingNull();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void makingNull()
	{
		pidTextReport.setText(null);
		pnameTextReport.setText(null);
		ppriceTextReport.setText(null);
		modalnoTextReport.setText(null);
		pstockTextReport.setText(null);
		descTextReport.setText(null);
		pptypeTextReport.setText(null);
	}
	

}
