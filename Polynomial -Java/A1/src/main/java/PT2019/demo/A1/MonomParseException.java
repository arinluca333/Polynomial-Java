package PT2019.demo.A1;

public class MonomParseException extends Throwable{

	char id;
	
	public MonomParseException(char c)
	{
		id = c;
	}
	
	public String toString() 
	{
		return "MonomParseException[" + id + "] : Unrecognized character: " + id;
	}

}
