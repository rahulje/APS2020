import java.util.*;

class Team
{
	private String name;
	private String batcoach,bowlcoach;
	private String captain;
	private p[] pr;
	private static int count;
	static
	{
		count=0;
	}
	Team()
	{
		pr=new p[15];
	}
	public void readTeam()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the team details 1->team name,2->Batting coach,3->Bowling coach,4->captain name");
		name=scan.nextLine();
		batcoach=scan.nextLine();
		bowlcoach=scan.nextLine();
		captain=scan.nextLine();
	}
	public void displayTeam()
	{
		System.out.println("The Team details are");		
		System.out.println("Team name :"+name+"\nBatting coach :"+batcoach+"\nBowling coach :"+bowlcoach+"\nnumber of players in the team are :"+count+"\ncaptain of the team :"+captain);
		System.out.println("want to display the player name if yes press 1 if no press any integer key");			
		Scanner scan=new Scanner(System.in);
		int ch=scan.nextInt();
		if(count==0)
		{
			System.out.println("players list empty");
		}
		else
		{
			if(ch==1)
			{		
				for(int i=0;i<count;i++)
				{
					System.out.println(pr[i].getname());
				}
			}
		}
	}
	public int check(int ch)
	{
		for(int i=0;i<count;i++)
		{
			if(pr[i].getjersey()==ch)
			{
				return(i);
			}
		}
		return(0);
	}

	public void addPlayer()
	{
		Scanner scan=new Scanner(System.in);
		int ch1,u;
		System.out.println("enter the type of player\n1->batsman \n2->bowler\n3->wicketkeeper");			
		int ch=scan.nextInt();		
		switch(ch)
		{
			case 1:System.out.println("enter the jersey number of the player");														
				ch1=scan.nextInt();
				u=check(ch1);
				if(u==0)
				{
					pr[count]=new batsman();
					pr[count].readPlayer(ch1);
					count++;
				}
				else
				{
					System.out.println("the jersey number with "+ch1+" already exist");
				}
				break;
			case 2:	System.out.println("enter the jersey number of the player");														
				ch1=scan.nextInt();
				u=check(ch1);
				if(u==0)
				{
					pr[count]=new bowler();
					pr[count].readPlayer(ch1);
					count++;
				}
				else
				{
					System.out.println("the jersey number with "+ch1+" already exist");
				}
				break;
			case 3:System.out.println("enter the jersey number of the player");														
				ch1=scan.nextInt();
				u=check(ch1);
				if(u==0)
				{
					pr[count]=new wicketKeeper();
					pr[count].readPlayer(ch1);
					count++;
				}
				else
				{
					System.out.println("the jersey number with "+ch1+" already exist");
				}
				break;	
			default :System.out.println("invalid entry try again");	
		}
	}
	public void displaydetail()
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the jersey number of the player");
		int ch=scan.nextInt();
		int j=check(ch);	
		if(j==0)
		{
			System.out.println("The jersey number with "+ch+" doesnt exist");
		}
		else
		{
			pr[j].displayPlayer();
		}
	}
	public void deletePlayer()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the jersey number of the player");
		int ch=scan.nextInt();
		int j=check(ch);	
		if(j==0)
		{
			System.out.println("The jersey number with "+ch+" doesnt  exist");
		}
		else
		{
			for(int k=j;k<(count-1);k++)
			{
				pr[k]=pr[k+1];
			}
			count--;
		}
	}
	public void displayall()
	{
		for(int i=0;i<count;i++)
		{
			pr[i].displayPlayer();	
		}
	}		

}


	
		
	
