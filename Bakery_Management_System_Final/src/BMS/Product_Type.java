package BMS;

public class Product_Type {

	String ptype, desc;
	int id;
	public Product_Type(String ptype, String desc)
	{
		super();
		this.ptype=ptype;
		this.desc=desc;
	}
	
	public Product_Type(int id, String ptype, String desc)
	{
		super();
		this.id=id;
		this.ptype=ptype;
		this.desc=desc;
	}
	
	public Product_Type()
	{
		
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setPtype(String ptype)
	{
		this.ptype=ptype;
	}
	
	public void setDesc(String desc)
	{
		this.desc=desc;
	}
	
	public String getPtype()
	{
		return ptype;
	}
	
	public String getDesc()
	{
		return desc;
	}
}
