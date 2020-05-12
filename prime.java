import java.util.*;
class prime
{
	public static void main(String args[])
	{
		int n,m,s,i,j;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the range number to be checked to be prime r not");
		n=scan.nextInt();
		m=scan.nextInt();
		for(j=n;j<m;j++)
		{
			if(j==0 || j==1)
			{
				System.out.println("the number "+j+" is prime");
			}
			else
			{
				s=j/2;
				if(j==1)
				{
					System.out.println("the number "+j+" is prime");				
				}
				else
				{
					for( i=2;i<=s;i++)
					{
						if((j%i)==0)
						{
							System.out.println("the number "+j+" is not prime "+ i);										
							break;
						}
					}
					if(i==(s+1))
					{
						System.out.println("the number "+j+" is prime");				
					}
				}
			}
		
		}
	}
}
