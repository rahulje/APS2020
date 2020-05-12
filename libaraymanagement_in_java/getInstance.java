class getInstance
{
	static Book b=null;
	public static Book returnInstance(int ch)
	{
		if(ch==1)
		{
			b=new TextBook();
		}
		else if(ch==2)
		{
			b=new Magazine();
		}
		return b;
	}
}
	
