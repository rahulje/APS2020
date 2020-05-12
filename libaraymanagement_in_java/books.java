import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import com.mysql.jdbc.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.text.ParseException; 
import java.time.format.DateTimeFormatter;
import java.time.Period;
interface Book
{
	public void readBook() throws NegativeClassException;
	public void displayBook();
	//public void searchBook();
	//public void updateBook();
	//public void modifyBook();
	//public void deleteBook();
	public void setId(int id);
	public void setName(String name);
	public void setPublisher(String pub);
	public void setAuthor(String aut);
	public void setPrice(int price);
	public void setNop(int nop);
	public int getId();
	public String getName();
	public String getPublisher();
	public String getAuthor();
	public int getPrice();
	public int getNop();
	public void modify();
}
 abstract class AbstractBook implements Book
{
	protected int id;
	protected String name;
	protected String pub;
	protected String Auth;
	protected int price;
	protected int nop;
}
class TextBook extends AbstractBook
{
	TextBook()
	{
		this(0,"","","",0,0);
	}
	TextBook(int id,String name,String pub,String Auth,int price,int nop)
	{
		this.id=id;
		this.name=name;
		this.pub=pub;
		this.Auth=Auth;
		this.price=price;
		this.nop=nop;
	}
	public void readBook() throws NegativeClassException
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("\u001B[36m"+"ENTER THE BOOK ID"+"\u001B[36m");
		id=scan.nextInt();
		if(id<=0)
			throw(new NegativeClassException(1,"BOOK ID"));
		System.out.println("\u001B[36m"+"ENTER THE BOOK NAME"+"\u001B[36m");
		name=scan.next();
		System.out.println("\u001B[36m"+"ENTER THE PUBLISHER NAME"+"\u001B[36m");
		pub=scan.next();
		System.out.println("\u001B[36m"+"ENTER THE AUTHOR  NAME"+"\u001B[36m");		
		this.Auth=scan.next();
		System.out.println("\u001B[36m"+"ENTER THE BOOK PRICE"+"\u001B[36m");
		price=scan.nextInt();
		if(price<=0)
			throw(new NegativeClassException(1,"BOOK PRICE"));
		System.out.println("\u001B[36m"+"ENTER THE NUMBER OF PAGES"+"\u001B[36m");
		nop=scan.nextInt();
		if(nop<=0)
			throw(new NegativeClassException(1,"NUMBER OF PAGES"));
	}
	public void displayBook()
	{
		System.out.println("\u001B[93m"+"THE BOOK DETAILS IS"+"\u001B[93m");
		//System.out.println("THE BOOK DETAILS IS");
		System.out.println("\u001B[93m"+"BOOK ID             	:" +id+"\u001B[93m");
		System.out.println("\u001B[93m"+"BOOK NAME         	:" +name+"\u001B[93m");
		System.out.println("\u001B[93m"+"PUBLISHER NAME    	:" +pub+"\u001B[93m");
		System.out.println("\u001B[93m"+"AUTHOR NAME       	:" +Auth+"\u001B[93m");
		System.out.println("\u001B[93m"+"BOOK PRICE          	:" +price+"\u001B[93m");
		System.out.println("\u001B[93m"+"NUMBER OF PAGES   	:" +nop+"\u001B[93m");
		System.out.println("\u001B[93m"+"-------------------------------------------------"+"\u001B[93m");
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPublisher(String pub)
	{
		this.pub=pub;
	}
	public void setAuthor(String aut)
	{
		this.Auth=aut;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public void setNop(int nop)
	{
		this.nop=nop;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getPublisher()
	{
		return pub;
	}
	public String getAuthor()
	{
		return Auth;
	}
	public int getPrice()
	{
		return price;
	}
	public int getNop()
	{
		return nop;
	}
	public void modify()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("ENTER THE CHOICE\n1:MODIFY NAME\n2:MODIFY PUBLISHER\n3:MODIFY AUTHOR\n4:MODIFY ALL");
		int ch=scan.nextInt();
		switch(ch)
		{
			case 1: System.out.println("\u001B[36m"+"ENTER THE MODIFIED NAME"+"\u001B[36m");
					this.name=scan.next();	
					break;
			case 2: System.out.println("\u001B[36m"+"ENTER THE MODIFIED PUBLISHER"+"\u001B[36m");
					this.pub=scan.next();
					break;
			case 3: System.out.println("\u001B[36m"+"ENTER THE MODIFIED AUTHOR"+"\u001B[36m");
					this.Auth=scan.next();
					break;
			case 4:	System.out.println("\u001B[36m"+"ENTER THE MODIFIED NAME"+"\u001B[36m");
					this.name=scan.next();	
					System.out.println("\u001B[36m"+"ENTER THE MODIFIED PUBLISHER"+"\u001B[36m");
					this.pub=scan.next();
					System.out.println("\u001B[36m"+"ENTER THE MODIFIED AUTHOR"+"\u001B[36m");
					this.Auth=scan.next();
					break;
		}
	}
}

class Magazine extends AbstractBook
{
	Magazine()
	{
		this(0,"","","",0,0);
	}
	public Magazine(int id,String name,String pub,String Auth,int price,int nop)
	{
		this.id=id;
		this.name=name;
		this.pub=pub;
		this.Auth=Auth;
		this.price=price;
		this.nop=nop;
	}
	public void readBook() throws NegativeClassException
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("\u001B[36m"+"ENTER THE BOOK ID"+"\u001B[36m");
		id=scan.nextInt();
		if(id<=0)
			throw(new NegativeClassException(1,"BOOK ID"));
		System.out.println("\u001B[36m"+"ENTER THE BOOK NAME"+"\u001B[36m");
		name=scan.next();
		System.out.println("\u001B[36m"+"ENTER THE PUBLISHER NAME"+"\u001B[36m");
		pub=scan.next();
		System.out.println("\u001B[36m"+"ENTER THE AUTHOR  NAME"+"\u001B[36m");		
		this.Auth=scan.next();
		System.out.println("\u001B[36m"+"ENTER THE BOOK PRICE"+"\u001B[36m");
		price=scan.nextInt();
		if(price<=0)
			throw(new NegativeClassException(1,"BOOK PRICE"));
		System.out.println("\u001B[36m"+"ENTER THE NUMBER OF PAGES"+"\u001B[36m");
		nop=scan.nextInt();
		if(nop<=0)
			throw(new NegativeClassException(1,"NUMBER OF PAGES"));
	}
	public void displayBook()
	{
		System.out.println("\u001B[93m"+"THE BOOK DETAILS IS"+"\u001B[93m");
		//System.out.println("THE BOOK DETAILS IS");
		System.out.println("\u001B[93m"+"BOOK ID             	:" +id+"\u001B[93m");
		System.out.println("\u001B[93m"+"BOOK NAME         	:" +name+"\u001B[93m");
		System.out.println("\u001B[93m"+"PUBLISHER NAME    	:" +pub+"\u001B[93m");
		System.out.println("\u001B[93m"+"AUTHOR NAME       	:" +Auth+"\u001B[93m");
		System.out.println("\u001B[93m"+"BOOK PRICE          	:" +price+"\u001B[93m");
		System.out.println("\u001B[93m"+"NUMBER OF PAGES   	:" +nop+"\u001B[93m");
		System.out.println("\u001B[93m"+"-------------------------------------------------"+"\u001B[93m");
		
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPublisher(String pub)
	{
		this.pub=pub;
	}
	public void setAuthor(String aut)
	{
		this.Auth=aut;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public void setNop(int nop)
	{
		this.nop=nop;
	}
		public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getPublisher()
	{
		return pub;
	}
	public String getAuthor()
	{
		return Auth;
	}
	public int getPrice()
	{
		return price;
	}
	public int getNop()
	{
		return nop;
	}
	public void modify()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("\u001B[92m"+"ENTER THE CHOICE\n1:MODIFY NAME\n2:MODIFY PUBLISHER\n3:MODIFY AUTHOR\n4:MODIFY ALL"+"\u001B[92m");
		int ch=scan.nextInt();
		switch(ch)
		{
			case 1: System.out.println("\u001B[36m"+"ENTER THE MODIFIED NAME"+"\u001B[36m");
					this.name=scan.next();	
					break;
			case 2: System.out.println("\u001B[36m"+"ENTER THE MODIFIED PUBLISHER"+"\u001B[36m");
					this.pub=scan.next();
					break;
			case 3: System.out.println("\u001B[36m"+"ENTER THE MODIFIED AUTHOR"+"\u001B[36m");
					this.Auth=scan.next();
					break;
			case 4:	System.out.println("\u001B[36m"+"ENTER THE MODIFIED NAME"+"\u001B[36m");
					this.name=scan.next();	
					System.out.println("\u001B[36m"+"ENTER THE MODIFIED PUBLISHER"+"\u001B[36m");
					this.pub=scan.next();
					System.out.println("\u001B[36m"+"ENTER THE MODIFIED AUTHOR"+"\u001B[36m");
					this.Auth=scan.next();
					break;
		}
	}
	
}


class libarary
{	
	private Connection c;
	studentdata stud=new studentdata();
	Record r=new Record();
	public libarary()
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
	public void addBook(Book s,int ch)
	{
		
		//Statement st=c.createStatement();
		/*String qry="insert into student values("+s.getrollnor()+",'"+s.getname()+"',"+s.getper()+")";*/
		if(ch==1)
		{
			try{
			PreparedStatement ps=c.prepareStatement("insert into TEXTBOOK values(?,?,?,?,?,?)");
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getPublisher());
			ps.setString(4,s.getAuthor());
			ps.setInt(5,s.getPrice());
			ps.setInt(6,s.getNop());
			int cnt=ps.executeUpdate();
			System.out.println("\u001B[92m"+"ONE TEXTBOOK INSERTED SUCCESFULLY"+"\u001B[92m");
			}catch(Exception e)
			{	
				e.printStackTrace();
			}	
		}
		else if(ch==2)
		{
			try{
			PreparedStatement ps=c.prepareStatement("insert into MAGAZINE values(?,?,?,?,?,?)");
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getPublisher());
			ps.setString(4,s.getAuthor());
			ps.setInt(5,s.getPrice());
			ps.setInt(6,s.getNop());
			int cnt=ps.executeUpdate();
			System.out.println("\u001B[92m"+"ONE MAGAZINE INSERTED SUCCESFULLY"+"\u001B[92m");
			}catch(Exception e)
			{	
				e.printStackTrace();
			}
		}
	}
			
	public void modifyBook(int id,int ch)
	{
		if(ch==1)
		{
			try{
			Statement st=c.createStatement();
			Book s1=new TextBook();
			String qry="select * from TEXTBOOK where id="+id+";";
			ResultSet res=st.executeQuery(qry);
			while(res.next())
			{
				Book s=new TextBook(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
				s.modify();
				s1=s;
		}
		qry="update TEXTBOOK set name="+"'"+s1.getName()+"',publisher='"+s1.getPublisher()+"',author='"+s1.getAuthor()+"' where id="+id+";";
		int cnt=st.executeUpdate(qry);
		
		
		if(cnt==0)
			System.out.println("\u001B[91m"+"BOOK RECORD NOT FOUND"+"\u001B[91m");
		else
			System.out.println("\u001B[92m"+"BOOK RECORD UPDATED SUCCESFULLY"+"\u001B[92m");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else if(ch==2)
		{
				try{
			Statement st=c.createStatement();
			Book s1=new Magazine();
			String qry="select * from MAGAZINE where id="+id+";";
			ResultSet res=st.executeQuery(qry);
			while(res.next())
			{
				Book s=new Magazine(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
				s.modify();
				s1=s;
			}
			qry="update MAGAZINE set name="+"'"+s1.getName()+"',publisher='"+s1.getPublisher()+"',author='"+s1.getAuthor()+"' where id="+id+";";
			int cnt=st.executeUpdate(qry);
			if(cnt==0)
				System.out.println("\u001B[91m"+"BOOK RECORD NOT FOUND"+"\u001B[91m");
			else
				System.out.println("\u001B[92m"+"BOOK RECORD UPDATED SUCEEFULLY"+"\u001B[92m");	
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
	}
	public void deleteBook(int id,int ch)
	{
		switch(ch)
		{
			case 1:
			try{
				Statement st=c.createStatement();
				String qry="delete from TEXTBOOK"+" where id="+id+";";
				int cnt=st.executeUpdate(qry);
				if(cnt==0)
					System.out.println("\u001B[91m"+"BOOK RECORD NOT FOUND"+"\u001B[91m");
				else
					System.out.println("\u001B[92m"+"BOOK RECORD DELETED SUCCESFULLY"+"\u001B[92m");	
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			break;
			case 2:
					try{
					Statement st=c.createStatement();
					String qry="delete from MAGAZINE"+" where id="+id+";";
					int cnt=st.executeUpdate(qry);
					if(cnt==0)
						System.out.println("\u001B[91m"+"BOOK RECORD NOT FOUND"+"\u001B[91m");
					else
						System.out.println("\u001B[92m"+"BOOK RECORD DELETED SUCCESFULLY"+"\u001B[92m");	
					}catch(Exception e)
					{
						e.printStackTrace();
					}
			break;
			}
		
	}
	public ArrayList<Book> searchBook(int id,int ch) 
	{
		ArrayList<Book> lst=new ArrayList<Book>();
		switch(ch)
		{
			case 1:


		
				String qry1="select * from TEXTBOOK where id="+id+";";
				try
				{
					Statement st=c.createStatement();
					ResultSet res=st.executeQuery(qry1);
					while(res.next())
					{
						Book s=new TextBook(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
						lst.add(s);
					}
					res.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				return lst;
			case 2:
			

		
			String qry="select * from MAGAZINE where id="+id+";";
			try
			{
				Statement st=c.createStatement();
				ResultSet res=st.executeQuery(qry);
				while(res.next())
				{
					Book s=new Magazine(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
					lst.add(s);
				}
				res.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		return lst;
	}	
	
	public ArrayList<Book> fetchall(int ch) 
	{
		ArrayList<Book> lst=new ArrayList<Book>();
		switch(ch)
		{
			case 1:
			String qry="select * from TEXTBOOK";
			try
			{
				Statement st=c.createStatement();
				ResultSet res=st.executeQuery(qry);
				while(res.next())
				{
					Book s=new TextBook(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
					lst.add(s);
				}
				res.close();
			}catch(Exception e)
			{
					e.printStackTrace();
			}
			break;
			case 2:

			String qry1="select * from MAGAZINE";
			try
			{
				Statement st=c.createStatement();
				ResultSet res=st.executeQuery(qry1);
				while(res.next())
				{
					Book s=new Magazine(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6));
					lst.add(s);
				}
				res.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			}
			return lst;
			
	}
	public void issueBook() throws NegativeClassException,InvalidUsnException
	{
		Scanner scan=new Scanner(System.in);
		String usn;
		String issue;
		String Return;
		Calendar cal;
		String u;
		System.out.println("\u001B[92m"+"ENTER THE STUDENT USN NUMBER"+"\u001B[92m");
		usn=scan.next();
		u=usn.substring(0,4);
		if(!u.equals("01FE"))
			throw(new InvalidUsnException(3));	
		ArrayList<student> lst=stud.searchstudent(usn);
		if(lst.size()==0)
		{
			System.out.println("\u001B[91m"+"THE STUDENT RECORD NOT FOUND IN THE DATABASE"+"\u001B[91m");
		}
		else
		{
			System.out.println("\u001B[92m"+"STUDENT RECORD FOUND IN THE DATABASE\n"+"\u001B[92m");
			for(student e:lst)
			{
				e.displayStudent();	
				if(e.getIssue()==1 || e.getIssue()==0)
				{
					if(e.getCount()<3)
					{
						System.out.println("\u001B[92m"+"ENTER THE TYPE OF BOOK YOU WANT TO ISSUE\n1:TEXTBOOK\n2:MAGAZINE"+"\u001B[92m");
						int ch=scan.nextInt();
						if(ch>=3||ch<=0)
						{
							System.out.println("\u001B[91m"+"YOU HAVE ENTERED THE INVALID OPTION"+"\u001B[91m");
						}
						else
						{
						
							System.out.println("\u001B[92m"+"ENTER THE BOOK ID YOU WANT TO ISSUE"+"\u001B[92m");
							int key=scan.nextInt();
							if(key<=0)
								throw(new NegativeClassException(1,"CHOICE"));
							ArrayList<Book> lst1=searchBook(key,ch);
							if(lst1.size()==0)
							{
								System.out.println("\u001B[91m"+"THE BOOK ID NOT FOUND"+"\u001B[91m");
							}
							else
							{
								System.out.println("\u001B[92m"+"THE BOOK FOUND AND DEATILS ARE SHOWN BELOW"+"\u001B[92m");
								for(Book f:lst1)
								{
									f.displayBook();
									ArrayList<Record> lst3=new ArrayList<Record>();
									lst3=r.check(f.getId(),ch);
									if(lst3.size()==0)
									{
										LocalDate date=LocalDate.now();
										issue=""+date;
										LocalDate date1=LocalDate.now().plusDays(15);
										Return=""+date1;
										r.insert(usn,key,ch,issue,Return);
										System.out.println("\u001B[92m"+"\nBOOK ISSUED SUCCESFULLY"+"\u001B[92m");
										System.out.println("\u001B[93m"+"\nTHE LAST DATE OF RETURN BOOK : "+Return+"\u001B[93m");
										stud.update(usn,(e.getCount()+1));
									}
									else
									{	
										for(Record r1:lst3)
										{	
											System.out.println("\u001B[31m"+"NOTE : THE BOOK ID WITH "+r1.Bookid+" HAS BEEN ALREADY ISSUED BY THE STUDENT WITH THE USN "+r1.usn+"\u001B[0m");
										}
									}
										
								}
						
							
							}
						}
					}
					else
					{
						System.out.println("\u001B[31m"+"NOTE : THE USN WITH "+e.getUsn()+" HAS REACHED HIS MAXIMUM LIMIT OF TAKING BOOKS"+ "\u001B[0m");
					}
				}
			}
		}
	}
	
	
	
	public void returnBook()  throws DateFormatException,NegativeClassException,InvalidUsnException
	{
		Scanner scan=new Scanner(System.in);
		String usn;
		String Return;
		Calendar cal;
		String u;
		System.out.println("\u001B[92m"+"ENTER THE STUDENT USN NUMBER"+"\u001B[92m");
		usn=scan.next();
		u=usn.substring(0,4);
		if(!u.equals("01FE"))
			throw(new InvalidUsnException(3));	
		ArrayList<student> lst=stud.searchstudent(usn);
		if(lst.size()==0)
		{
			System.out.println("\u001B[91m"+"THE STUDENT RECORD NOT FOUND IN THE DATABASE"+"\u001B[91m");
		}
		else
		{
			for(student e:lst)
			{
				if(e.getCount()==0)
				{
					System.out.println("\u001B[91m"+"NOTE: THE STUDENT WITH USN "+e.getUsn()+" HAS NOT TAKEN ANY BOOK"+"\u001B[91m");
				}
				else
				{
					System.out.println("\u001B[92m"+"ENTER THE TYPE OF BOOK YOU WANT TO RETURN\n1:TEXTBOOK\n2:MAGAZINE"+"\u001B[92m");
					int ch=scan.nextInt();
					if(ch>=3||ch<=0)
					{
						System.out.println("\u001B[91m"+"YOU HAVE NOT ENTERED THE CORRECT CHOICE"+"\u001B[91m");
					}
					else
					{
						System.out.println("\u001B[92m"+"ENTER THE BOOK ID YOU WANT TO RETURN"+"\u001B[92m");
						int key=scan.nextInt();
						if(key<=0)
						{
							System.out.println("\u001B[91m"+"YOU HAVE ENTERED THE NEGATIVE NUMBER "+"\u001B[91m");
						}
						else
						{
							ArrayList<Book> lst1=searchBook(key,ch);
							if(lst1.size()==0)
							{
								System.out.println("\u001B[91m"+"THE BOOK ID YOU HAVE ENTERED IS NOT FOUND IN THE DATABSE"+"\u001B[91m");
							}
							else
							{
								for(Book f:lst1)
								{
									System.out.println("\u001B[92m"+"THE BOOK DETAILS IS SHOWN BELOW"+"\u001B[92m");
									f.displayBook();
									ArrayList<Record> lst3=new ArrayList<Record>();
									lst3=r.check(f.getId(),ch);
									if(lst3.size()==0)
									{
										System.out.println("\u001B[91m"+"THE ENTERED BOOK ID HAS NOT BEEN TOOK BY ANY ONE "+"	\u001B[91m");
									}
									else
									{
										for(Record r1:lst3)
										{
											if(usn.equals(r1.usn))
											{
												System.out.println("ENTER THE YEAR");
												int year=scan.nextInt();
												if(year<=0)
													throw(new NegativeClassException(1,"YEAR"));
												if(year<=2018)
													throw(new DateFormatException(2,"YEAR"));
												System.out.println("ENTER THE MONTH");
												int month=scan.nextInt();
												if(month<=0)
													throw(new NegativeClassException(1,"YEAR"));
												if(month<=0 || month >=13)
													throw(new DateFormatException(2,"MONTH"));
												System.out.println("ENTER THE DAY");
												int day=scan.nextInt();
												if(day<=0)
													throw(new NegativeClassException(1,"YEAR"));
												if(day<=0 || day>=32)
													throw(new DateFormatException(2,"DAY"));
												LocalDate d1 = LocalDate.of(year, month, day);
												LocalDate d2 = LocalDate.parse(r1.returnDate);
        										if (d1.compareTo(d2) < 0 || d1.compareTo(d2) == 0) 
        										{ 
            										System.out.println("\u001B[92m"+"DONT HAVE ANY FINE"+"\u001B[92m"); 
        										}
        										else if (d1.compareTo(d2) > 0) 
        										{ 
  														Period diff = Period.between(d2,d1); 
            											int days=diff.	getDays();
            											int fine=0;
            											if(days>=1 && days<=5)
            											{
            												fine=days*1;
            											}
            											else if(days>=6 && days<=10)
            											{
            												fine=(5*1)+days*5;
            											}
            											else if(days>=11 && days<=20)
	            											{
            												fine=(5*1)+(5*5)+days*10;
            											}
            											else
            											{
            												fine=(5*1)+(5*5)+(10*10)+days*20;
            											}
            										System.out.println("\u001B[91m"+"YOU HAVE RETURNED THE BOOK LATE BY "+days+" DAYS SO THE FINE YOU HAVE TO PAY IS :"+" "+fine+" Rs"+"\u001B[91m");
            												
            											 
            											
        										}   	
												r1.deleteRecord(key,ch,usn);
												System.out.println("\u001B[92m"+"\nBOOK RETURNED SUCCESFULLY"+"\u001B[92m");
												stud.update(usn,(e.getCount()-1));
											}
											else
											{
												System.out.println("\u001B[91m"+"THIS BOOK HAS BEEN TOOK BY THE USN "+r1.usn+" NOT BY THE "+usn+"\u001B[91m");
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
									
	}
		
}
class m
{
	public static void main(String[] args) throws ParseException 
	{
		libarary se=new libarary();	
		studentdata st=new studentdata();
		student sa=new student();	
		int ch,ch1,ch2;
		int key;
		String u;
		String usn;
		Book s;
		Scanner scan=new Scanner(System.in);
		do
		{
			System.out.println("\u001B[94m"+"\nENTER THE CHOICE\n1:STUDENT\n2:LIBRARY\n3:EXIT"+"\u001B[94m");
			ch2=scan.nextInt();
			switch(ch2)
			{
				case 1:
				do
				{
					System.out.println("\u001B[32m"+"\nENTER THE CHOICE\n1:ADD STUDENT\n2:DISPLAY ALL STUDENT DEATAILS\n3:MODIFY STUDENT DETAILS\n4:DELETE STUDENT RECORD\n5:SEARCH STUDENT\n6:EXIT\n"+"\u001B[32m");
					ch=scan.nextInt();
					switch(ch)
					{
						case 1:	try{
						sa.readStudent();
								st.addstudent(sa);
								}catch(InvalidUsnException i)
								{
									System.out.println(i);
								}
						break;	
						case 2 :	ArrayList<student> t;
						t=st.fetchall();
						for(student d:t)
						{
							d.displayStudent();
						}
						break;	
						case 3: 	try{
						System.out.println("\u001B[94m"+"ENTER THE STUDENT USN NUMBER TO BE MODIFIED"+"\u001B[94m");
						usn=scan.next();
						u=usn.substring(0,4);
						if(!u.equals("01FE"))
							throw(new InvalidUsnException(3));
						st.modifyStudent(usn);
						}catch(InvalidUsnException i)
						{
									System.out.println(i);
						}
						break;
						case 4: try{
						System.out.println("\u001B[94m"+"ENTER THE STUDENT USN TO BE MODIFIED"+"\u001B[94m");
						usn=scan.next();
						u=usn.substring(0,4);
						if(!u.equals("01FE"))
							throw(new InvalidUsnException(3));	
						st.deletestudent(usn);
						}catch(InvalidUsnException i)
						{
									System.out.println(i);
						}
						break;
						case 5: 	try{
						
						System.out.println("\u001B[94m"+"ENTER THE USN TO BE SEARCHED"+"\u001B[94m");
						usn=scan.next();	
						u=usn.substring(0,4);
						if(!u.equals("01FE"))
							throw(new InvalidUsnException(3));	
						ArrayList<student> lst=st.searchstudent(usn);
							if(lst.size()==0)
							{
								System.out.println("\u001B[91m"+"THE STUDENTS DETAILS NOT FOUND"+"\u001B[91m");
							}	
							else
							{
								for(student e:lst)
								{
									e.displayStudent();		
								}
							}
						}catch(InvalidUsnException i)
						{
							System.out.println(i);
						}
						break;
						case 6:break;
					
					}
				}while(ch!=6);		
				break;
				case 2:
				do
				{
					System.out.println("\u001B[32m"+"\nENTER THE CHOICE \n1:ADD BOOK\n2:DISPLAY ALL BOOK\n3:MODIFY BOOK\n4:DELETE BOOK\n5:SEARCH BOOK\n6:ISSUE BOOK\n7:RETURN BOOK\n8:EXIT\n"+"\u001B[32m");
					ch=scan.nextInt();
					switch(ch)
					{
						case 1:	
						try{
						System.out.println("\u001B[92m"+"ENTER THE CHOICE\n1:TEXT BOOK\n2:MAGAZINE"+"\u001B[92m");
						ch1=scan.nextInt();
						if(ch1<=0)
							throw(new NegativeClassException(1,"CHOICE"));
						s=getInstance.returnInstance(ch1);
						s.readBook();
						se.addBook(s,ch1);
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}
						break;	
						case 2 :	try{
						ArrayList<Book> t;
						System.out.println("\u001B[92m"+"ENTER THE CHOICE\n1:TEXT BOOK\n2:MAGAZINE"+"\u001B[92m");
						ch1=scan.nextInt();
						if(ch1<=0)
							throw(new NegativeClassException(1,"CHOICE"));
						t=se.fetchall(ch1);
						for(Book d:t)
						{
							d.displayBook();
						}
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}
						break;
						
							
						case 3: 	try{
						System.out.println("\u001B[92m"+"ENTER THE CHOICE\n1:TEXT BOOK\n2:MAGAZINE"+"\u001B[92m");
						ch1=scan.nextInt();
						if(ch1<=0)
							throw(new NegativeClassException(1,"CHOICE"));
						System.out.println("ENTER THE BOOK ID TO BE MODIFIED");
						key=scan.nextInt();
						if(key<=0)
							throw(new NegativeClassException(1,"BOOKID"));
						se.modifyBook(key,ch1);
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}
						break;
						case 4: 	try{
						System.out.println("\u001B[92m"+"ENTER THE CHOICE\n1:TEXT BOOK\n2:MAGAZINE"+"\u001B[92m");
						ch1=scan.nextInt();
						if(ch1<=0)
							throw(new NegativeClassException(1,"CHOICE"));
						System.out.println("ENTER THE BOOK ID TO BE DELETED");
						key=scan.nextInt();	
						if(key<=0)
							throw(new NegativeClassException(1,"BOOKID"));
						se.deleteBook(key,ch1);
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}
						break;
						case 5: 	try{
						System.out.println("\u001B[92m"+"ENTER THE CHOICE\n1:TEXT BOOK\n2:MAGAZINE"+"\u001B[92m");
						ch1=scan.nextInt();
						if(ch1<=0)
							throw(new NegativeClassException(1,"CHOICE"));
						System.out.println("ENTER THE BOOK ID TO BE SEARCHED");
						key=scan.nextInt();	
						if(key<=0)
							throw(new NegativeClassException(1,"BOOKID"));
						ArrayList<Book> lst=se.searchBook(key,ch1);
						if(lst.size()==0)
						{
							System.out.println("\u001B[91m"+"THE BOOK RECORD NOT FOUND"+"\u001B[91m");
						}	
						else
						{
							for(Book e:lst)
							{
								e.displayBook();		
							}
						}
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}
						break;
						case 6:	try{
						se.issueBook();
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}	
						catch(InvalidUsnException i)
						{
							System.out.println(i);
						}
							
						break;
						case 7:	try{
						se.returnBook();
						}catch(NegativeClassException n)
						{
							System.out.println(n);
						}
						catch(DateFormatException d)
						{	
							System.out.println(d);
						}
						catch(InvalidUsnException i)
						{
							System.out.println(i);
						}
							
						break;
						case 8:
						break;
					
					}
				}while(ch!=8);
				break;
			case 3:se.close();		
		}
	}while(ch2!=3);
	
	}
}

		
	
