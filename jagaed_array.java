import java.util.*;
class jaged
{
	public static void main(String[] args)
	{
		int a[][];
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the number of rows");
		a=new int[scan.nextInt()][];
		for(int i=0;i<a.length;i++)
		{
			System.out.println("enter the number of columns u want in the row "+i);
			a[i]=new int[scan.nextInt()];
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println("enter the data of row "+i+ " of length "+a[i].length);
			for(int j=0;j<a[i].length;j++)
			{
				

				a[i][j]=scan.nextInt();
			}
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println("\nthe data of  "+i+ " row are:");
			for(int j=0;j<a[i].length;j++)
			{
				

				System.out.print(a[i][j]+ " ");
			}
		}
		System.out.println("");

	}
}
				
