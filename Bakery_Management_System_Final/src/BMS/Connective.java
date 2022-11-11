package BMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connective {

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","abc123");
		return con;
	}
}