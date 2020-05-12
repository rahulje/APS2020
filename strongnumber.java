import java.util.*;
class strong
{
	public static void main(String[] args)
	{
		int n,t,rem;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number");	
		n=scan.nextInt();	
		t=n;
		int fact,sum=0;
		while(t!=0)
		{
			fact=1;
			rem=t%10;
			for(int i=1;i<=rem;i++)
			{
				fact=fact*i;
			}
			sum=sum+fact;
			t=t/10;
		}
		if(n==sum)
		{
			System.out.println("the number is strong");
		}
		else
		{
			System.out.println("the number is not strong");
		}
	}
}
