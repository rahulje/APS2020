import java.util.*;
abstract class Account{
private int accno;
private String name;
private String address;
private static int count;
protected int totalbal;
static
{
	count=1001;
}
public void read()
{
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the details of the account\n1->name\n2->address\n");
	accno=count++;
	name=scan.nextLine();
	address=scan.nextLine();
}
public void display()
{
	System.out.println("Account Number :"+accno+"\nAccount Holder Name :"+name+"\nAddress :"+address);
}
public final int returnAccno()
{
	System.out.println(accno);
	return(accno);
}
abstract public int returnamt();
abstract public void update(int amt,int ch);
}
class SavingAccount extends Account{
private String accType="Saving Account";
private int depositAmount=0;
public void read()
{
	super.read();
	totalbal=500;
	System.out.println(" Saving Account created successfully Here is details of your Account");
	super.display();
	System.out.println("Total bal :"+totalbal+"\nAccount Type :"+accType);
}
public void display()
{
	System.out.println("The  Saving Account account details are:");
	super.display();
	System.out.println("Total bal :"+totalbal+"\nAccount Type :"+accType);
}	
public int returnamt()
{
	return(totalbal);
}
public void update(int amt,int ch)
{
	if(ch==1)
	{
		totalbal=totalbal+amt;
	}
	else if(ch==2)
	{
		totalbal=totalbal-amt;
	}
}
}

class CurrentAccount extends Account{
private String accType="Current Account";
public void read()
{
	super.read();
	totalbal=1000;
	System.out.println(" Current Account created successfully Here is details of your Account");
	super.display();
	System.out.println("Total bal :"+totalbal+"\nAccount Type :"+accType);
}
public void display()
{
	System.out.println("The  Current Account account details are:");
	super.display();
	System.out.println("Total bal :"+totalbal+"\nAccount Type :"+accType);
}	
public int returnamt()
{
	return(totalbal);
}
public void update(int amt,int ch)
{
	if(ch==1)
	{
		totalbal=totalbal+amt;
	}
	else if(ch==2)
	{
		totalbal=totalbal-amt;
	}
}
}
class Bank
{
	int count=0;
	Account[] a=new Account[100];
	public void createAccount()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the choice\n1:current account\n2:saving account");
		int ch=scan.nextInt();
		switch(ch)
		{
			case 1:	a[count]=new CurrentAccount();
					a[count].read();
					count++;
					break;
			case 2: a[count]=new SavingAccount();
					a[count].read();
					count++;
					break;
		}
	}
	public void search(int key)
	{
		int middle,first,last;
		first=0;
		last=this.count-1;
		middle=(last+first)/2;
		while(first<=last)
		{
			if(a[middle].returnAccno()>key)
			{
				last=middle-1;
			}
			else if(a[middle].returnAccno()==key)
			{
				a[middle].display();
				break;
			}
			else if(a[middle].returnAccno()<key)
			{
				first=middle+1;
			}
			middle=(first+last)/2;
		}
		if(first>last)
			System.out.println("not found");
	}
	public void displayall()
	{
		for(int i=0;i<count;i++)
			a[i].display();
	}
}
class Main{
	public static void main(String[] args)
	{
		Bank b=new Bank();
		Scanner scan=new Scanner(System.in);
		int ch;
		do
		{
			System.out.println("enter the choice\n1:craete\n2:search");
			ch=scan.nextInt();
			switch(ch)
			{
				case 1: b.createAccount();
						break;
				case 2: System.out.println("enter the key");
					int key=scan.nextInt();
					b.search(key);
						break;
				case 3:b.displayall();
					break;
			}
		}while(ch!=4);
	}
}
				

	







	
	
	
	
	
	
	
	

	
