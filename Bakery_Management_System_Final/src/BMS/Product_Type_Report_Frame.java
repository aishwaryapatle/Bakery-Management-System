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

public class Product_Type_Report_Frame {

	private static JFrame frame5;
	private static JTextField txtID;
	private static JTextField txtPtype;
	private static JTextField txtDesc;
	public static JTable table = new JTable();

	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Connection conn;

	public static void Product_Type_Report_Frame_Code() throws ClassNotFoundException, SQLException
	{
		initialize();
		showTable();
	}
	
	
	private static void initialize() {
		
		frame5 = new JFrame("Product Type Report");
		frame5.setBounds(100, 100, 450, 300);

		PanelButton.PanelButtonCode(frame5, 1);
		
		JLabel heading = new JLabel("Product Type Report");
		heading.setBounds(825,50,650,50);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Times New Roman", Font.BOLD,32));
		frame5.add(heading);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(700,480,200,35);
		lblId.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame5.getContentPane().add(lblId);
		
		
		txtID = new JTextField();
		txtID.setBounds(850,480,400,35);
		txtID.setFont(new Font("Times New Roman", Font.PLAIN,20));
		txtID.setEditable(false);
		frame5.getContentPane().add(txtID);
		

		JLabel lblPtype = new JLabel("Product Type");
		lblPtype.setBounds(700,530,200,35);
		lblPtype.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame5.getContentPane().add(lblPtype);

		
		txtPtype = new JTextField();
		txtPtype.setBounds(850,530,400,35);
		txtPtype.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(txtPtype);
		
		
		JLabel lblDesc = new JLabel("Description");
		lblDesc.setBounds(700,580,200,35);
		lblDesc.setFont(new Font("Times New Roman", Font.PLAIN,23));
		frame5.getContentPane().add(lblDesc);


		txtDesc = new JTextField();
		txtDesc.setBounds(850,580,400,100);
		txtDesc.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(txtDesc);
		
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="UPDATE bakery.ProductType SET ptype='"+txtPtype.getText()+"', description='"+txtDesc.getText()+"' WHERE id='"+txtID.getText()+"'";
				try {
					queryUpdate(sql, "Updated");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		update.setBounds(850,720,170,35);
		update.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(update);

		
		
		JButton delete = new JButton("Delete");
		//  btnDelete.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Actions-edit-delete-icon.png"));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM bakery.ProductType WHERE id='"+txtID.getText()+"'";
				try {
					queryUpdate(sql, "Deleted");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		delete.setBounds(1080,720,170,35);
		delete.setFont(new Font("Times New Roman", Font.PLAIN,20));
		frame5.getContentPane().add(delete);


		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				TableModel model = (TableModel)table.getModel();
				txtID.setText(model.getValueAt(row, 0).toString());
				txtPtype.setText(model.getValueAt(row, 1).toString());
				txtDesc.setText(model.getValueAt(row, 2).toString());

			}
		});

		table.setModel(new DefaultTableModel(
			new Object[][] {}, new String[] {"id", "Product Type", "Description"}
		));
		
		table.setRowHeight(30);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN,20));

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(192,192,192));
		tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(700, 150, 550, 250);
		frame5.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		
		
		JPanel panel = new JPanel();
		JLabel img = new JLabel(new ImageIcon("D:/Project/Images/Bakery6.1 (1).png"));
		panel.add(img);
		panel.setBounds(718, 8, 1202, 800);
		panel.setBackground(new Color(250,225,227));
		frame5.add(panel);
		
		
		frame5.setLayout(new FlowLayout());
		frame5.getContentPane().setBackground(new Color(250,225,227));
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setLayout(null);
		frame5.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame5.setVisible(true);

	}
	
	public static ArrayList<Product_Type> getArrayList(){
		ArrayList <Product_Type> list  = new ArrayList();
		try {
			conn = Connective.getConnection();
			stmt = conn.prepareStatement("Select * From bakery.ProductType");
			rs = stmt.executeQuery();
			while(rs.next()){
				Product_Type user = new Product_Type(rs.getInt("id"),rs.getString("ptype"),rs.getString("description"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void showTable(){
		ArrayList <Product_Type> list = getArrayList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] cols = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			cols[0] = list.get(i).getId();
			cols[1] = list.get(i).getPtype();
			cols[2] = list.get(i).getDesc();
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
				txtID.setText(null);
				txtPtype.setText(null);
				txtDesc.setText(null);
				conn.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	
}