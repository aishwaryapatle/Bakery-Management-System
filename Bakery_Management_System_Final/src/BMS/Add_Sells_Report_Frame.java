package BMS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Add_Sells_Report_Frame {

	private static JFrame frame8;
	private static JTextField txtID;
	private static JTextField txtPtype;
	private static JTextField txtDesc;
	public static JTable table = new JTable();

	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Connection conn;

	public static void Add_Sells_Report_Frame_Code() throws ClassNotFoundException, SQLException
	{
		initialize();
		showTable();
	}
	
	
	private static void initialize() {
		
		frame8 = new JFrame("Sells Report");
		frame8.setBounds(100, 100, 450, 300);

		PanelButton.PanelButtonCode(frame8, 1);
		
		JLabel heading = new JLabel("Sells Report");
		heading.setBounds(900,50,650,50);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Times New Roman", Font.BOLD,32));
		frame8.add(heading);
		
		
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				int row = table.getSelectedRow();
//				TableModel model = (TableModel)table.getModel();
//				txtID.setText(model.getValueAt(row, 0).toString());
//				txtPtype.setText(model.getValueAt(row, 1).toString());
//				txtDesc.setText(model.getValueAt(row, 2).toString());
//
//			}
//		});

		
		table.setModel(new DefaultTableModel(
			new Object[][] {}, new String[] {"Customer Id", "Customer Name", "Customer Contact", "Date"}
		));
		
		table.setRowHeight(30);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN,20));

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(192,192,192));
		tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(600, 150, 750, 300);
		frame8.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		
		
		JPanel panel = new JPanel();
		JLabel img = new JLabel(new ImageIcon("D:/Project/Images/Bakery6.1 (1).png"));
		panel.add(img);
		panel.setBounds(718, 8, 1202, 800);
		panel.setBackground(new Color(250,225,227));
		frame8.add(panel);
		
		
		frame8.setLayout(new FlowLayout());
		frame8.getContentPane().setBackground(new Color(250,225,227));
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.setLayout(null);
		frame8.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame8.setVisible(true);

	}
	
	
	
	public static ArrayList<Add_Sells> getArrayList(){
		ArrayList <Add_Sells> list  = new ArrayList();
		try {
			conn = Connective.getConnection();
			stmt = conn.prepareStatement("Select * From bakery.addSells1");
			rs = stmt.executeQuery();
			while(rs.next()){
				Add_Sells user = new Add_Sells(rs.getInt("customerid"),rs.getString("customername"),rs.getString("customercontact"),rs.getString("date1"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void showTable(){
		ArrayList<Add_Sells> list = getArrayList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] cols = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			cols[0] = list.get(i).getCid();
			cols[1] = list.get(i).getCname();
			cols[2] = list.get(i).getCnum();
			cols[3] = list.get(i).getDate1();
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
				

				conn.close();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Not "+message + " Successfully!");
				conn.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	
}