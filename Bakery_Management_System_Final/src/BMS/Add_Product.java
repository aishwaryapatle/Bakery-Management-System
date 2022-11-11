package BMS;

public class Add_Product {

	String pname, pptype, pdescription;
	int id, modelno, pprice, pstock;
	public Add_Product(String pname, int modelno, String pptype, int pprice, int pstock,  String pdescription)
	{
		super();
		this.pname=pname; 
		this.pptype=pptype; 
		this.pdescription=pdescription;
		this.modelno=modelno; 
		this.pprice=pprice; 
		this.pstock=pstock;
	}
	
	public Add_Product(int id, String pname, int modelno, String pptype, int pprice, int pstock,  String pdescription)
	{
		super();
		this.id=id;
		this.pname=pname; 
		this.pptype=pptype; 
		this.pdescription=pdescription;
		this.modelno=modelno; 
		this.pprice=pprice; 
		this.pstock=pstock;
	}
	
	public Add_Product(int id, String pname, String pptype, int pprice)
	{
		super();
		this.id=id;
		this.pname=pname; 
		this.pptype=pptype; 
		this.pprice=pprice; 
	}
	
	public Add_Product()
	{
		
	}
	
	
	public void setPname(String pname)
	{
		this.pname=pname;
	}
	
	public void setPptype(String pptype)
	{
		this.pptype=pptype;
	}
	
	public void setPdescription(String pdescription)
	{
		this.pdescription=pdescription;
	}
	
	public void setModelno(int modelno)
	{
		this.modelno=modelno;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setPprice(int pprice)
	{
		this.pprice=pprice;
	}
	
	public void setPstock(int pstock)
	{
		this.pstock=pstock;
	}
	
	
	public String getPname()
	{
		return pname;
	}
	
	public String getPptype()
	{
		return pptype;
	}
	
	public String getPdescription()
	{
		return pdescription;
	}
	
	public int getModelno()
	{
		return modelno;
	}
	
	public int getPprice()
	{
		return pprice;
	}
	
	public int getPstock()
	{
		return pstock;
	}
	
	public int getId()
	{
		return id;
	}
	
	
}
