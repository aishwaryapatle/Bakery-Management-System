package BMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Add_Product_Connectivity {

	public static int Add_Product_Connectivity_Code(Add_Product a) throws ClassNotFoundException, SQLException
	{
		Connection con = Connective.getConnection();
		Statement st = con.createStatement();
		int x = st.executeUpdate("INSERT INTO bakery.addProduct (pname, modelno, pptype, pprice, pstock, pdescription) VALUES "
				+ "('"+a.getPname()+"', "+a.getModelno()+", '"+a.getPptype()+"', "+a.getPprice()+", "+a.getPstock()+",'"+a.getPdescription()+"')");
		con.close();
		return x;
	}
}
