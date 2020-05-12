/*class Demo implements Runnable
{
	Thread t;
	public Demo()
	{
		t=new Thread(this);
		t.start();
	}
			
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("child:"+i);
		}
	}
	public static void main(String[] args)
	{
		new Demo();
		for(int i=0;i<10;i++)
		{
			System.out.println("main:"+i);
		}
	}
}*/
/*class Demo extends Thread
{
	public Demo()
	{
		start();
	}
			
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("child:"+i);
		}
	}
	public static void main(String[] args)
	{
		new Demo();
		for(int i=0;i<10;i++)
		{
			System.out.println("main:"+i);
		}
	}
}*/
import java.util.*;
class array
{
	public int a[];
	public int sum[];
	public void read()
	{
		System.out.println("enter the array size:");
		Scanner scan=new Scanner(System.in);
		a=new int[scan.nextInt()];
		sum=new int[2];
		System.out.println("enter the array numbers:");
		for(int i=0;i<a.length;i++)
		{
			a[i]=scan.nextInt();
		}
		for(int i=0;i<2;i++)
		{
			sum[i]=0;
		}
	}
}
class Demo extends Thread
{
	int s;
	array A;
	Demo(array A,int i)
	{
		s=i;
		this.A=A;
	}
		
	public void run()
	{
		for(int i=s;i<A.a.length;i=i+2)
		{

			A.sum[s]=A.sum[s]+A.a[i];
			System.out.println(Thread.currentThread());
		}
	}
}
class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		array d=new array();
		d.read();
		Demo[] e=new Demo[2];
		for(int i=0;i<2;i++)
		{
			e[i]=new Demo(d,i);
			e[i].start();
			e[i].join();
		}
		int total=0;
		for(int i=0;i<2;i++)
		{
			total=total+d.sum[i];
		}
		System.out.println("the total is:"+total);
	}
}
	
