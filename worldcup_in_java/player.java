import java.util.*;
interface pla
{
	public String getname();
	public int getjersey();
}
interface p extends pla
{
	public void readPlayer(int ch);
	public void displayPlayer();
}
abstract class player implements pla
{
	private String name;
	private String birth;
	private int age,jersey;
	
	public void readPlayer(int ch)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the player details1->name,2->birth place,3->age");
		name=scan.nextLine();
		birth=scan.next();
		age=scan.nextInt();
		jersey=ch;
	}
	public void displayPlayer()
	{
		System.out.println("name :"+name+"\nBirth place :"+birth+"\nage :"+age+"\njersey number :"+jersey);
	}
	public String getname()
	{
		return(name);
	}
	public int getjersey()
	{
		return jersey;
	}
}
class batsman extends player implements p
{
	private String role="Batsman";
	private String style;
	private int matches,runs,best;
	public void readPlayer(int ch)
	{
		super.readPlayer(ch);
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the style,matches,runs and best");
		style=scan.nextLine();
		matches=scan.nextInt();
		runs=scan.nextInt();
		best=scan.nextInt();
	}
	public void displayPlayer()
	{
		super.displayPlayer();
		System.out.println("The batting career summary in ODI is:");
		System.out.println("Role :"+role+"\nBatting style :"+style+"\nNumber of matches played in ODI is :"+matches+"\nTotal runs scored :"+runs+"\nBest score :"+best);
	}
}
class bowler extends player implements p
{
	private String role="Bowler";
	private String style;
	private int matches,wick,best;
	public void readPlayer(int ch)
	{
		super.readPlayer(ch);
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the bowling style,total number of matches,total wickets and best");
		style=scan.nextLine();
		matches=scan.nextInt();
		wick=scan.nextInt();
		best=scan.nextInt();
	}
	public void displayPlayer()
	{
		super.displayPlayer();
		System.out.println("The bowling career summary in ODI is:");
		System.out.println("Role :"+role+"\nBowling style :"+style+"\nNumber of matches played in ODI is :"+matches+"\nTotal wickets Taken in ODI :"+wick+"\nBest :"+best);
	}
}
class wicketKeeper extends player implements p
{
	private String role="wicket keeper";
	private String style;
	private int matches,runs,best;
	public void readPlayer(int ch)
	{
		super.readPlayer(ch);
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the style,matches,runs and best");
		style=scan.nextLine();
		matches=scan.nextInt();
		runs=scan.nextInt();
		best=scan.nextInt();
	}
	public void displayPlayer()
	{
		super.displayPlayer();
		System.out.println("The batting career summary in ODI is:");
		System.out.println("Role :"+role+"\nBatting style :"+style+"\nNumber of matches played in ODI is :"+matches+"\nTotal runs scored :"+runs+"\nBest score :"+best);
	}
}
		
		
		
