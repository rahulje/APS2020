import java.util.*;
class name
{
	private String firstname;
	private String middlename;
	private String lastname;
	name()
	{
		this("","","");
	}
	name(String x,String y,String z)
	{
		firstname=x;
		middlename=y;
		lastname=z;
	}
	public void readname()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the firtsname,middlename,latsname");
		firstname=scan.next();
		middlename=scan.next();
		lastname=scan.next();
	}
	public void displayname()
	{
		System.out.println(firstname+"."+middlename+"."+lastname);
	}
}
