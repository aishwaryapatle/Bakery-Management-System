package BMS;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Product_Type_Connectivity {

	public static int Product_Type_Connectivity_Code(Product_Type p) throws ClassNotFoundException, SQLException
	{
		Connection con = Connective.getConnection();
		Statement st = con.createStatement();
		int x = st.executeUpdate("INSERT INTO bakery.ProductType (ptype, description) VALUES ('"+p.getPtype()+"', '"+p.getDesc()+"')");
		con.close();
		return x;
	}
}