package PT2019.demo.A1;

public class Main {

	static Polinom p1 = new Polinom();
	static Polinom p2 = new Polinom();
	static Polinom p3 = new Polinom();
	public static void main(String args[])
	{
		Monom m1 = new Monom(1, 0);

		System.out.println(m1);
		System.out.println(m1.deriv());
		Screen s = new Screen();
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		Polinom p3 = new Polinom();
	}
	
	public static String deriv(String s, int i) throws MonomParseException
	{
		if(i == 1)
		{
			try {
				p1 = Polinom.sToP(s);
			} catch (MonomParseException e) {
				throw(e);
			}
			p1.deriv();
			return ("" + p1);
		}
		else
		{	
			if( i == 2) 
			{
				try {
					p2 = Polinom.sToP(s);
				} catch (MonomParseException e) {
					throw(e);
				}
				p2.deriv();
				return ("" + p2);
			}
			else
			{
				try {
					p3 = Polinom.sToP(s);
				} catch (MonomParseException e) {
					throw(e);
				}
				p3.deriv();
				return ("" + p3);
			}
			
		}
	}
	public static String integ(String s, int i) throws MonomParseException
	{
		if(i == 1)
		{
			try {
				p1 = Polinom.sToP(s);
			} catch (MonomParseException e) {
				throw(e);
			}
			p1.integ();
			return ("" + p1);
		}
		else
		{
			if(i == 2)
			{
				try {
					p2 = Polinom.sToP(s);
				} catch (MonomParseException e) {
					throw(e);
				}
				p2.integ();
				return ("" + p2);
			}
			else
			{
				try {
					p3 = Polinom.sToP(s);
				} catch (MonomParseException e) {
					throw(e);
				}
				p3.integ();
				return ("" + p3);
			}
		}
	}
	public static String add(String s1, String s2)throws MonomParseException
	{
		try {
			p3 = Polinom.sToP(s1);
		} catch (MonomParseException e) {
			throw(e);
		}
		try {
			p3.add(Polinom.sToP(s2));
		} catch (MonomParseException e) {
			throw(e);
		}
		return ("" + p3);
	}
	public static String sub(String s1, String s2)throws MonomParseException
	{
		try {
			p3 = Polinom.sToP(s1);
		} catch (MonomParseException e) {
			throw(e);
		}
		try {
			p3.sub(Polinom.sToP(s2));
		} catch (MonomParseException e) {
			throw(e);
		}
		return ("" + p3);
	}
	public static String mul(String s1, String s2)throws MonomParseException
	{
		try {
			p3 = Polinom.sToP(s1);
		} catch (MonomParseException e) {
			throw(e);
		}
		try {
			p3.mul(Polinom.sToP(s2));
		} catch (MonomParseException e) {
			throw(e);
		}
		return ("" + p3);
	}
	public static String div(String s1, String s2)throws MonomParseException
	{
		try {
			p3 = Polinom.sToP(s1);
		} catch (MonomParseException e) {
			throw(e);
		}
		try {
			p3.div(Polinom.sToP(s2));
		} catch (MonomParseException e) {
			throw(e);
		}
		return ("" + p3);
	}
}
