import java.util.*;
class sum
{
	public static void main(String[] args)
	{
		int[] a;
		int even=0,odd=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the range");
		a=new int[scan.nextInt()];
		System.out.println("enter the array elments");
		for(int i=0;i<(a.length);i++)
		{
			a[i]=scan.nextInt();
		}
		for(int i=0;i<(a.length);i++)
		{
			if(a[i]%2==0)
			{
				even=even+a[i];
			}
			else
			{
				odd=odd+a[i];
			}
		}
		System.out.println("the sum of even is: "+even+" sum of odd is:"+odd);
	}
}
		
