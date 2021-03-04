package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
	private static Connection con=null;
	
	public static Connection getcon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
				
		} 
		catch (Exception e) 
		{
		System.out.println(e);
		}
		return con;
	}

}
