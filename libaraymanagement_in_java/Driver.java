import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import com.mysql.jdbc.*;
import java.sql.ResultSet;

class driver
{
	private static Connection c=null;
	public  static Connection getConnection()
	{
		if(c==null)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/KLE_LIBRARY";
				String user="root";
				String pass="";
				c=DriverManager.getConnection(url,user,pass);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return c;
	}
}
