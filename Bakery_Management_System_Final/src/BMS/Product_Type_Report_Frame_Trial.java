package BMS;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Product_Type_Report_Frame_Trial {

	private JFrame frame5;
	private JTextField txtID;
	private JTextField txtPtype;
	private JTextField txtDesc;
	public JTable table;

	private PreparedStatement stmt;
	private ResultSet rs;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Type_Report_Frame_Trial window = new Product_Type_Report_Frame_Trial();
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Product_Type_Report_Frame_Trial() {
		initialize();
		try {
			conn = Connective.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		showTable();
	}

	public ArrayList<Product_Type> getArrayList(){
		ArrayList <Product_Type> list  = new ArrayList();
		try {
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
	
	public void showTable(){
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

	public void queryUpdate(String sql,String message){
		try {
			stmt = conn.prepareStatement(sql);
			if(stmt.executeUpdate()==1){
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				showTable();
				JOptionPane.showMessageDialog(null, message + " Successfully!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame5 = new JFrame();
		frame5.setTitle("Person Table\r\n");
		frame5.setBounds(100, 100, 450, 300);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(137, 13, 127, 20);
		frame5.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtPtype = new JTextField();
		txtPtype.setColumns(10);
		txtPtype.setBounds(137, 44, 127, 20);
		frame5.getContentPane().add(txtPtype);

		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(137, 80, 127, 20);
		frame5.getContentPane().add(txtDesc);


//		JButton btnInser = new JButton("Insert");
//		//  btnInser.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\add-icon.png"));
//		btnInser.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String sql ="INSERT INTO bakery.ProductType (ptype, description) "
//						+ "VALUES ('"+txtPtype.getText()+"', '"+txtDesc.getText()+"')";
//				queryUpdate(sql,"Insert");
//			}
//		});
//
//		btnInser.setBounds(309, 10, 98, 23);
//		frame5.getContentPane().add(btnInser);

		JButton btnUdate = new JButton("Update");
		//  btnUdate.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Actions-edit-redo-icon.png"));
		btnUdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="UPDATE bakery.ProductType SET ptype='"+txtPtype.getText()+"', description='"+txtDesc.getText()+"' WHERE id='"+txtID.getText()+"'";
				queryUpdate(sql, "Update");
			}
		});
		btnUdate.setBounds(309, 56, 98, 23);
		frame5.getContentPane().add(btnUdate);

		JButton btnDelete = new JButton("Delete");
		//  btnDelete.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\Actions-edit-delete-icon.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM bakery.ProductType WHERE id='"+txtID.getText()+"'";
				queryUpdate(sql, "Delete");
			}
		});

		btnDelete.setBounds(309, 111, 98, 23);
		frame5.getContentPane().add(btnDelete);

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
				txtPtype.setText(model.getValueAt(row, 1).toString());
				txtDesc.setText(model.getValueAt(row, 2).toString());

			}
		});

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"id", "Product Type", "Description"
				}
				));
		scrollPane.setViewportView(table);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 14, 76, 14);
		frame5.getContentPane().add(lblId);

		JLabel lblPtype = new JLabel("PType");
		lblPtype.setBounds(29, 45, 76, 14);
		frame5.getContentPane().add(lblPtype);

		JLabel lblDesc = new JLabel("Desc");
		lblDesc.setBounds(29, 81, 76, 14);
		frame5.getContentPane().add(lblDesc);

	}
}
