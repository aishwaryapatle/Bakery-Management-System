package BMS;

public class Login_Page {

	String username, password;
	public Login_Page(String username, String password)
	{
		super();
		this.username=username;
		this.password=password;
	}
	
	public Login_Page()
	{
		
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
}
