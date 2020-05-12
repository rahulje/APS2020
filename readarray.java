import java.util.*;
class demoarray
{
	public static void main(String[] args)
	{
		int[] a;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the range");
		a=new int[scan.nextInt()];
		System.out.println("enter the array elements");
		for(int i=0;i<a.length;i++)
		{
			a[i]=scan.nextInt();
		}
		for(int i=0;i<(a.length-1);i++)
		{
			for(int j=0;j<(a.length-1);j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("the array elements are");
		for(int data:a)
		{
			System.out.println(data);
		}
	}
}
