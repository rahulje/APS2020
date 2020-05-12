class NegativeClassException extends Exception
{
	public int erroNo;
	public String name;
	public NegativeClassException(int i,String n)
	{
		erroNo=i;
		name=n;
	}
	public String toString()
	{
		return("\u001B[91m"+"ERROR NUMBER: "+erroNo+"\n"+"ERROR MESSAGE :"+"THE "+name+" CANNOT BE NEGATIVE"+"\u001B[91m");
	}
}

class DateFormatException extends Exception
{
	int erroNo;
	String name;
	public DateFormatException(int i,String n)
	{
		erroNo=i;
		name=n;
	}
	public String toString()
	{
		return("\u001B[91m"+"ERROR NUMBER: "+erroNo+"\n"+"ERROR MESSAGE :"+"THE ENTERED "+name+"IS INCORRECT"+"\u001B[91m");
	}
}
class InvalidUsnException extends Exception
{
	int errno;
	public InvalidUsnException(int i)
	{
		errno=i;
	}
	public String toString()
	{
		return("\u001B[91m"+"ERROR NUMBER: "+errno+"\nERROR MESSAGE: THE ENTERED USN IS INVALID"+"\u001B[91m");
	}
} 
