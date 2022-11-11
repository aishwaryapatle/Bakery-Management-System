package BMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_Page_Connectivity {
	
	static public ResultSet Login_Page_Connectivity_Code(Login_Page l) throws ClassNotFoundException, SQLException
	{
		Connection con = Connective.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT name, password from login where name=? and password=?");
		st.setString(1, l.getUsername());
		st.setString(2, l.getPassword());
		ResultSet rs = st.executeQuery();
		
		return rs;
		
	}
	

}
