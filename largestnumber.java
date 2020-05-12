import java.util.*;
class demo
{
	public static void main(String[] args)
	{
	int n,ch,l,s;
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the range");
	n=scan.nextInt();
	System.out.println("enter the first element");
	ch=scan.nextInt();
	l=ch;
	s=ch;
	for(int i=1;i<n;i++)
	{
		ch=scan.nextInt();
		if(ch>l)
		   l=ch;
		if(ch<s)
		   s=ch;

	}
	System.out.println("the largest number is:"+l+" the smallest is:"+s);
}
}
