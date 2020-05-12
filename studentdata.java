
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
	private int rollnor;
	private String name;
	private float per;
	public student()
	{
		this(0,"",0.0f);
	}
	public student(int roll,String na,float pe)
	{
		rollnor=roll;
		name=na;
		per=pe;
	}
	public void readStudent()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the student details");
		rollnor=scan.nextInt();
		name=scan.next();
		per=scan.nextFloat();
		
	}
	String getname()
	{
		return name;
	}
	float getper()
	{
		return per;
	}
	int getrollnor()
	{
		return rollnor;
	}
	public void displayStudent()
	{
		System.out.println("rollnor:"+rollnor+" ,name:"+name+" ,per:"+per);
	}
}
class studentdata
{	
	private Connection c;
	public studentdata()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/BVB";
		String user="root";
		String pass="";
		c=DriverManager.getConnection(url,user,pass);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
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
	
		PreparedStatement ps=c.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1,s.getrollnor());
		ps.setString(2,s.getname());
		ps.setFloat(3,s.getper());
		int cnt=ps.executeUpdate();
		System.out.println("one Student inserted succefully");
		}catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
	public void modifyStudent(int rollnor,student s)
	{
		try{
		Statement st=c.createStatement();
		String qry="update student set name="+"'"+s.getname()+"',per="+s.getper()+" where rollnor="+rollnor+";";
		int cnt=st.executeUpdate(qry);
		if(cnt==0)
			System.out.println("recors not found");
		else
			System.out.println("updated sucessfully");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void deletestudent(int rollnor)
	{
		try{
		Statement st=c.createStatement();
		String qry="delete from student"+" where rollnor="+rollnor+";";
		int cnt=st.executeUpdate(qry);
		if(cnt==0)
			System.out.println("recors not found");
		else
			System.out.println("deleted sucessfully sucessfully");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList<student> searchstudent(int rollnor) 
	{

		ArrayList<student> lst=new ArrayList<student>();
		
		String qry="select * from student where rollnor="+rollnor+";";
		try
		{
			Statement st=c.createStatement();
			ResultSet res=st.executeQuery(qry);
			while(res.next())
			{
				student s=new student(res.getInt(1),res.getString(2),res.getFloat(3));
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
		String qry="select * from student";
		try
		{
				Statement st=c.createStatement();
		ResultSet res=st.executeQuery(qry);
		while(res.next())
		{
			student s=new student(res.getInt(1),res.getString(2),res.getFloat(3));
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
class m
{
	public static void main(String[] args) 
	{
		studentdata se=new studentdata();	
		int ch;
		student s=new student();
		Scanner scan=new Scanner(System.in);
		do
		{
			System.out.println("enter the choice \n1:add student\n2:fetchall student\n3:modify student\n4:delete student\n5:search student\n6:exit");
			ch=scan.nextInt();
			switch(ch)
			{
				case 1:	s.readStudent();
						se.addstudent(s);
						break;	
				case 2 :ArrayList<student> t;
						t=se.fetchall();
						for(student d:t)
						{
							d.displayStudent();
						}
						break;	
				case 3: System.out.println("enter the rollnor to be modifeid:");
					int key=scan.nextInt();
					//s.modify();
					se.modifyStudent(key,s);
					break;
				case 4: System.out.println("enter the rollnor to be deleted:");
					key=scan.nextInt();	
					se.deletestudent(key);
					break;
				case 5: System.out.println("enter the rollnor to be searched:");
					key=scan.nextInt();	
					ArrayList<student> lst=se.searchstudent(key);
					if(lst.size()==0)
					{
						System.out.println("the student record not found");
					}	
					else
					{
						for(student e:lst)
						{
							e.displayStudent();		
						}
					}
					break;
				case 6:se.close();
					break;
					
			}
		}while(ch!=6);		
	}
}
