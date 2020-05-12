import java.util.*;
class employeedetails
{
	private employe[] e=new employe[10];
	private int count=0;
	public void addemployee()
	{
		e[count]=new employe();
		e[count].reademployee();
		count++;
	}
	public void displayallemployee()
	{
		for(int i=0;i<count;i++)
		{
			e[i].displayEmployee();
			System.out.println("------------------------------------------");
		}
	}
	public void searchEmployee(int key)
	{
		for(int i=0;i<count;i++)
		{
			if(e[i].getempno()==key)
			{
				System.out.println("record found");
				e[i].displayEmployee();
				return;
			}
		}
		System.out.println("record not found");
	}
	
		
}
class Main
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int ch,key;
	employeedetails em=new employeedetails();
	do
	{
		System.out.println("enter the choice\n1:add\n2:displayall\n3:search");
		ch=scan.nextInt();	
		switch(ch)
		{
		case 1:em.addemployee();
			break;
		case 2:em.displayallemployee();
			break;
		case 3:System.out.println("enter the employee number");
			key=scan.nextInt();
			em.searchEmployee(key);
			break;
		case 4:break;
		}
	}while(ch!=4);
	}
}
	
