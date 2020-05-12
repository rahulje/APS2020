
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import com.mysql.jdbc.*;
import java.sql.ResultSet;
class Record
{
	public String usn;
	public int Bookid;
	public String Booktype;
	public String issueDate;
	public String returnDate;
	public Connection c;
	public Record()
	{
		
		this("",0,"","","");
	}
	public Record(String usn,int bookid,String Type,String issueD,String ReturnD)
	{
		c=driver.getConnection();
		this.usn=usn;
		this.Bookid=bookid;
		this.Booktype=Type;
		this.issueDate=issueD;
		this.returnDate=ReturnD;
	}
	public ArrayList<Record> check(int Bookid,int ch)
	{
		ArrayList<Record> lst=new ArrayList<Record>();
		String qry1;
		switch(ch)
		{
			case 1:
			qry1="select * from Record where bookid="+Bookid+" and BookType= 'Textbook';";
			try{
			Statement st=c.createStatement();
			ResultSet res=st.executeQuery(qry1);
			while(res.next())
			{
				Record r=new Record(res.getString(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5));
				lst.add(r);
			}
			res.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
			case 2:
			qry1="select * from Record where bookid="+Bookid+" and BookType= 'Magazine';";
			try{
			Statement st=c.createStatement();
			ResultSet res=st.executeQuery(qry1);
			while(res.next())
			{
				Record r=new Record(res.getString(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5));
				lst.add(r);
			}
			res.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			break;
		}
		return(lst);
	}
	public void insert(String usn,int bookid,int ch,String issue,String Return)
	{
	    String sd="";
	    if(ch==1)
	    {
	        sd="Textbook";
	    }
	    else if(ch==2)
	    {
	        sd="Magazine";
	    }
	    try{
	    Statement st=c.createStatement();
	    String qry="insert into Record values('"+usn+"',"+bookid+",'"+sd+"','"+issue+"','"+Return+"');";
	    int cnt=st.executeUpdate(qry);
		}catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
	public void deleteRecord(int bookid,int ch,String usn)
	{
		String sd="";
		if(ch==1)
			sd="Textbook";
		else
			sd="Magazine";
		try{
			Statement st=c.createStatement();
			String qry="delete from Record where bookid="+bookid+" and BookType='"+sd+"';";
			int cnt=st.executeUpdate(qry);
			//System.out.println("one Record inserted succefully");
		}catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
}
			
