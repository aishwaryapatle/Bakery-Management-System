package BMS;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Add_Sells {

	int cid, orderid;
	String cname, cnum, date1;
	int quantity;
	String item; 
	double cost, totalcost;
	
	java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-YYYY");
	
	
//	String mysqlDateString;
//	SimpleDateFormat formatter;
//	formatter = new SimpleDateFormat("dd-MM-YYYY");
//	mysqlDateString = formatter.format(date1);
	
	/*
	 String text = textField.getText();
	 java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-YYYY");
	 java.time.LocalDate textFieldAsDate  = java.time.LocalDate.parse(text, formatter);
	 java.sql.Date sqlDate = java.sql.date.valueOf(textFieldAsDate);
	 
	 */
	
	public Add_Sells(int cid, int orderid, String cname, String cnum, String date1, String item, double cost, int quantity, double totalcost)
	{
		super();
		this.cid=cid;
		this.orderid=orderid;
		this.cname=cname;
		this.cnum=cnum;
		this.date1=date1;
		this.item=item;
		this.cost=cost;
		this.quantity=quantity;
		this.totalcost=totalcost;
	}
	
	public Add_Sells(int orderid, int cid, String item, double cost, int quantity, double totalcost)
	{
		super();
		this.orderid=orderid;
		this.cid=cid;
		this.item=item;
		this.cost=cost;
		this.quantity=quantity;
		this.totalcost=totalcost;
	}
	
	public Add_Sells(int orderid, String item, double cost, int quantity, double totalcost)
	{
		super();
		this.orderid=orderid;
		this.cid=cid;
		this.item=item;
		this.cost=cost;
		this.quantity=quantity;
		this.totalcost=totalcost;
	}
	
	public Add_Sells(int cid, String cname, String cnum, String date1)
	{
		super();
		this.cid=cid;
		this.cname=cname;
		this.cnum=cnum;
		this.date1=date1;
	}
	
	public Add_Sells()
	{
		
	}
	
	
	public void setCid(int cid)
	{
		this.cid=cid;
	}
	
	public void setOrderid(int orderid)
	{
		this.orderid=orderid;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public void setCname(String cname)
	{
		this.cname=cname;
	}
	
	public void setCnum(String cnum)
	{
		this.cnum=cnum;
	}
	
	public void setItem(String item)
	{
		this.item=item;
	}
	
	public void setDate1(String date1)
	{
		this.date1=date1;
	}
	
	public void setCost(double cost)
	{
		this.cost=cost;
	}
	
	public void setTotalcost(double totalcost)
	{
		this.totalcost=totalcost;
	}
	

	
	public int getCid()
	{
		return cid;
	}
	
	public int getOrderid()
	{
		return orderid;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getCname()
	{
		return cname;
	}
	
	public String getCnum()
	{
		return cnum;
	}
	
	public String getItem()
	{
		return item;
	}
	
	public String getDate1()
	{
//		java.time.LocalDate textFieldAsDate  = java.time.LocalDate.parse(date1, formatter);
//		java.sql.Date sqlDate = java.sql.Date.valueOf(textFieldAsDate);
		return date1;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public double getTotalcost()
	{
		return cost*quantity;
	}
	
	
	
}
