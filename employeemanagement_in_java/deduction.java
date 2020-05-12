import java.util.*;
class deduction
{
	private int it,pt,lic;
	deduction()
	{
		this(0,0);
	}
	deduction(int x,int y)
	{
		lic=y;
		cal(x);
	}
	public void readdeduction(int x)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the lic amount");
		lic=scan.nextInt();
		cal(x);
	}
	public void cal(int x)
	{
		it=(int)(0.75*x);
		pt=(int)(0.3*x);
	}
	public int getit()
	{
		return(it);
	}
	public void displayDeduction()
	{
		System.out.println("it:"+it+" pt:"+pt+" lic:"+lic);
	}
}

