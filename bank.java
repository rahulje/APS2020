import java.util.*;
class bank
{
	private account s[]=new account[50];
	private int count=0;
	public void createAccount()
	{
		s[count]=new account();
		s[count].readAccount();
		System.out.println("account created succesfully");
		s[count].displayAccount();
		count++;
	}
	public void deposit()
	{
		Scanner scan=new Scanner(System.in);
		int amt,key;
		System.out.println("enter the account number ");
		key=scan.nextInt();
		for(int i=0;i<count;i++)
		{
			if(s[i].getaccno()==key)
			{
				System.out.println("account details found");
				s[i].displayAccount();
				System.out.println("enter the amount to be deposited");			
				amt=scan.nextInt();
				s[i].update(amt,1);
				System.out.println("deposited succesfully");
				return;
			}
		}
		System.out.println("the account details not found");		
	}
	public void withdraw()
	{
		Scanner scan=new Scanner(System.in);
		int amt,key;
		System.out.println("enter the account number ");
		key=scan.nextInt();
		for(int i=0;i<count;i++)
		{
			if(s[i].getaccno()==key)
			{
				System.out.println("account details found");
				s[i].displayAccount();
				System.out.println("enter the amount to be deposited");			
				amt=scan.nextInt();
				if(s[i].displayAmount()>500)
				{
					s[i].update(amt,2);
					System.out.println("withdrawed succesfully");
					return;
				}
				else
				{
					System.out.println("in sufficient balance");
					return;
				}
			}
		}
		System.out.println("the account details not found");		
	}
	public void displayaccountDetails()
	{
		Scanner scan=new Scanner(System.in);
		int key;
		System.out.println("enter the account number ");
		key=scan.nextInt();
		for(int i=0;i<count;i++)
		{
			if(s[i].getaccno()==key)
			{
				System.out.println("account details found");
				s[i].displayAccount();	
				return;
			}
		}
		System.out.println("the account details not found");		
	}
}
	
	
	
	
		
	
