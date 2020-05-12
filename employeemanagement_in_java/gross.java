import java.util.*;
class gross
{
	private int basic,hra,da,gs;
	gross()
	{
		this(0);
	}
	gross(int x)
	{
		basic=x;
		calculate(x);
	}
	public void readgross()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the basic salary");
		basic=scan.nextInt();
		calculate(basic);
	}
	public void calculate(int x)
	{
		hra=(int)(0.3*x);
		da=(int)(0.1*x);
		gs=x+hra+da;
	}
	public int getgs()
	{
		return(gs);
	}
	public void displaygross()
	{
		System.out.println("basic:"+basic+"   hra:"+hra+"   da:"+da+"   gs:"+gs);
	}
}
	
