import java.util.*;
interface istack
{	
	public void push(int data);
	public void pop();
}
class stack implements istack
{
	private int[] a;
	private int top;
	private int size;
	stack(int size)
	{
		a=new int[size];
		top=-1;
		this.size=size;
	}
	public void push(int data)
	{
		if(top==(size-1))
		{
	
			System.out.println("stack overflow");
		}
		else
		{
			top=top+1;
			a[top]=data;		
		}
	}
	public void pop()
	{
		if(top==-1)
		{
			System.out.println("stack underflow");	
		}
		else
		{
			int data=a[top];
			top=top-1;
			System.out.println("the poped data is"+data);
		}
	}
}
class Main
{
	public static void main(String[] args)
	{
		istack i=new stack(5);
		int ch;
		Scanner scan=new Scanner(System.in);
		do
		{
			System.out.println("enter the choice\n1->push\n2->pop");
			ch=scan.nextInt();
			switch(ch)
			{
			case 1:	System.out.println("enter the data to be pushed");
				i.push(scan.nextInt());
				break;
			case 2:i.pop();
				break;
			}
		}while(ch!=3);
	}
}
		
	
