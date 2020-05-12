import java.util.*;
class employe
{	
	private int empno;
	private name nm;
	private gross grs;
	private deduction de;
	private int nt;
	public void reademployee()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the employee number");
		empno=scan.nextInt();
		nm=new name();
		nm.readname();
		grs=new gross();
		grs.readgross();
		de=new deduction();
		de.readdeduction(grs.getgs());
		nt=grs.getgs()-de.getit();
	}
	public void displayEmployee()
	{
		System.out.println("empno:"+empno);
		nm.displayname();
		grs.displaygross();	
		de.displayDeduction();
		System.out.println("nt:"+nt);
	}
	public int getempno()
	{
		return(empno);
	}
}
		
