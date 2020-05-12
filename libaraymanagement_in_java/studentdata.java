
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import com.mysql.jdbc.*;
import java.sql.ResultSet;
class student 
{
	private String usn;
	private String name;
	private String branch;
	private int count;
	private int issue;
	private String contact;
	public student()
	{
		this("","","",0,0,"");
	}
	public student(String usn,String name,String branch,int count,int issue,String con)
	{
		this.usn=usn;
		this.name=name;
		this.branch=branch;
		this.contact=con;
		this.issue=issue;
		this.count=count;
	}
	public void readStudent() throws InvalidUsnException
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("ENTER THE STUDENT USN NUMBER");
		usn=scan.next();
		String s=usn.substring(0,4);
		if(!s.equals("01FE"))
			throw(new InvalidUsnException(3));
		System.out.println(s);
		System.out.println("ENTER THE STUDENT NAME");		
		name=scan.next();
		System.out.println("ENTER THE STUDENT BRANCH");
		branch=scan.next();
		System.out.println("ENTER THE STUDENT CONTACT NUMBER");
		contact=scan.next();
		this.issue=0;
		this.	count=0;	
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setUsn(String usn)
	{
		this.usn=usn;
	}
	public void setBranch(String branch)
	{
		this.branch=branch;
	}
	public void setContact(String con)
	{
		this.contact=con;
	}
	public void setIssue(int iss)
	{
		this.issue=iss;
	}
	public void setCount(int cnt)
	{
		count=cnt;
	}
	public String getname()
	{
		return name;
	}
	public int getCount()
	{
		return count;
	}
	public int getIssue()
	{
		return issue;
	}
	public String getUsn()
	{
		return usn;
	}
	public String getName()
	{
		return name;
	}
	public String getBranch()
	{
		return branch;
	}
	public String getContact()
	{
		return contact;
	}
	public void modify()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("ENTER THE CHOICE\n1:MODIFY NAME\n2:MODIFY BRANCH\n3:MODIFY CONTACT NUMBER\n4:MODIFY ALL");
		int ch=scan.nextInt();
		switch(ch)
		{
			case 1: System.out.println("ENTER THE MODIFIED NAME");
					this.name=scan.next();	
					break;
			case 2: System.out.println("ENTER THE MODIFIED BRANCH");
					this.name=scan.next();
					break;
			case 3: System.out.println("ENTER THE MODIFIED CONTACT");
					this.contact=scan.next();
					break;
			case 4:	System.out.println("ENTER THE MODIFIED NAME");
					this.name=scan.next();	
					System.out.println("ENTER THE MODIFIED BRANCH");
					this.name=scan.next();
					System.out.println("ENTER THE MODIFIED CONTACT");
					this.contact=scan.next();
					break;
		}
	}
					
	public void displayStudent()
	{
		//System.out.println("THE STUDENT DETAILS IS");
		System.out.println("\u001B[93m"+"STUDENT USN NUMBER         	:"+usn+"\u001B[93m");
		System.out.println("\u001B[93m"+"STUDENT NAME                 	:"+name+"\u001B[93m");
		System.out.println("\u001B[93m"+"STUDENT BRANCH              	:"+branch+"\u001B[93m");
		System.out.println("\u001B[93m"+"STUDENT CONTACT NUMBER    	:"+contact+"\u001B[93m");
		System.out.println("\u001B[93m"+"NUMBER OF BOOKS ISSUED   	:"+count+"\u001B[93m");
		System.out.println("---------------------------------------------------------------------");
		
	}
}
class studentdata
{	
	private Connection c;
	public studentdata()
	{
		c=driver.getConnection();
	}
	public void close()
	{
		try
		{
			c.close();
		}catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
	public void addstudent(student s)
	{
		try{
		Statement st=c.createStatement();
		/*String qry="insert into student values("+s.getrollnor()+",'"+s.getname()+"',"+s.getper()+")";*/
	
		PreparedStatement ps=c.prepareStatement("insert into STUDENT values(?,?,?,?,?,?)");
		ps.setString(1,s.getUsn());
		ps.setString(2,s.getName());
		ps.setString(3,s.getBranch());
		ps.setInt(4,s.getCount());
		ps.setInt(5,s.getIssue());
		ps.setString(6,s.getContact());
		int cnt=ps.executeUpdate();
		System.out.println("\nONE STUDENT DETAILS INSERTED SUCCESFULLY IN THE DATABASE");
		}catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
	public void modifyStudent(String usn)
	{
		try{
		Statement st=c.createStatement();
		student s1=new student();
		String qry="select * from STUDENT where USN='"+usn+"';";
		ResultSet res=st.executeQuery(qry);
		while(res.next())
		{
			student s=new student(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6));
			s.modify();
			s1=s;
		}
		qry="update STUDENT set name="+"'"+s1.getName()+"',branch='"+s1.getBranch()+"',contact='"+s1.getContact()+"' where USN='"+usn+"';";
		int cnt=st.executeUpdate(qry);
		if(cnt==0)
			System.out.println("\u001B[91m"+"STUDENT RECORD NOT FOUND"+"\u001B[91m");
		else
			System.out.println("\nSTUDENT RECORD UPDATED SUCCESFULLY");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void update(String usn,int count)
	{
		try{
		Statement st=c.createStatement();
		String qry="update STUDENT set COUNT="+count+" where USN='"+usn+"';";
		int cnt=st.executeUpdate(qry);
		if(cnt==0)
			System.out.println("\u001B[91m"+"STUDENT RECORD NOT FOUND"+"\u001B[91m");
			//System.out.println("STUDENT RECORD UPDATED SUCCESFULLY");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void deletestudent(String usn)
	{
		try{
		Statement st=c.createStatement();
		String qry="delete from STUDENT"+" where USN='"+usn+"';";
		int cnt=st.executeUpdate(qry);
		if(cnt==0)
			System.out.println("\u001B[91m"+"STUDENT RECORD NOT FOUND"+"\u001B[91m");
		else
			System.out.println("STUDENT RECORD UPDATED SUCCESFULLY");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList<student> searchstudent(String usn) 
	{

		ArrayList<student> lst=new ArrayList<student>();
		
		String qry="select * from STUDENT where USN='"+usn+"';";
		try
		{
			Statement st=c.createStatement();
			ResultSet res=st.executeQuery(qry);
			while(res.next())
			{
				student s=new student(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6));
				lst.add(s);
			}
			res.close();
		}catch(Exception e)
		{
				e.printStackTrace();
		}
		return lst;
	}	
	
	public ArrayList<student> fetchall() 
	{

		ArrayList<student> lst=new ArrayList<student>();
		String qry="select * from STUDENT";
		try
		{
				Statement st=c.createStatement();
		ResultSet res=st.executeQuery(qry);
		while(res.next())
		{
			student s=new student(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6));
			lst.add(s);
		}
		res.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lst;
	}	
		
}

