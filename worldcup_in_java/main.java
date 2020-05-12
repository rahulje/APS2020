import java.util.*;
class Main
{
	public static void main(String[] args)
	{
		Team x=new Team();
		int ch;
		Scanner scan=new Scanner(System.in);
		do
		{

			System.out.println("enter the choice\n1:add\n2:display\n3:delete");
			ch=scan.nextInt();
			switch(ch)
			{
				case 1:x.addPlayer();
					break;
				case 2:x.displaydetail();
					break;
				case 3:x.deletePlayer();
					break;
				case 4:x.displayall();
					break;
			}
		}while(ch!=5);
		
	}
}	

