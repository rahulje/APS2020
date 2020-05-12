import java.util.*;
class selection
{
	public static void main(String[] args)
	{
		int min,i,j;
		Scanner scan=new Scanner(System.in);
		int a[];
		System.out.println("enter the range ");
		a=new int[scan.nextInt()];
		System.out.println("enter the array elements");
		for( i=0;i<a.length;i++)
		{
			a[i]=scan.nextInt();
		}
		for( i=0;i<(a.length-1);i++)
		{
			min=i;
			for(j=i+1;j<a.length;j++)
			{
				if(a[j]>a[j+1])
					min=j;
			}
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		System.out.println("the array elements are");
		for(int data:a)
		{
			System.out.println(data);
		}
	}
}
