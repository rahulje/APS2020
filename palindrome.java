import java.util.*;
class palindrome
{
	public static void main(String[] args)
	{
		int n,t,rem,reverse=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number ");
		n=scan.nextInt();
		t=n;
		while(t!=0)
		{
			rem=t%10;
			reverse=(reverse*10)+rem;
			t=t/10;
		}
		if(reverse==n)
		{
			System.out.println("the number is palindrome");
		}
		else
		{
			System.out.println("the number is not palindrome");			
		}
	}
}
