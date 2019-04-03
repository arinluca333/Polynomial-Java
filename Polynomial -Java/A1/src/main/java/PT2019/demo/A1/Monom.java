package PT2019.demo.A1;

import java.util.regex.Pattern;

public class Monom implements Comparable<Monom>{
	
	private float exponent;
	private float coeficient;
	
	public Monom()
	{
		exponent = 0;
		coeficient = 0;
	}
	
	public Monom(float coef, float exp)
	{
		exponent = exp;
		coeficient = coef;
	}
	
	public float getExponent() {
		return exponent;
	}
	
	public void setExponent(float exponent) {
		this.exponent = exponent;
	}
	
	public float getCoeficient() {
		return coeficient;
	}
	
	public void setCoeficient(float coeficient) {
		this.coeficient = coeficient;
	}
	//addition
	public Monom add (Monom m)
	{
		Monom res = new Monom(0, 0);
		res.setCoeficient(coeficient + m.getCoeficient());
		res.setExponent(m.getExponent());
		return res;
	}
	//subtraction
	public Monom sub(Monom m)
	{
		Monom res = new Monom(0, 0);
		res.setCoeficient(coeficient - m.getCoeficient());
		res.setExponent(m.getExponent());
		return res;
	}
	//multiplication
	public Monom mul(Monom m)
	{
		Monom res = new Monom(0, 0);
		res.setCoeficient(coeficient * m.coeficient);
		res.setExponent(exponent + m.getExponent());
		return res;
	}
	//division
	public Monom div(Monom m)
	{
		Monom res = new Monom(0, 0);
		res.setCoeficient(coeficient / m.coeficient);
		res.setExponent(exponent - m.getExponent());
		return res;
	}
	//derivation
	public Monom deriv()
	{
		Monom res = new Monom(0, 0);
		if(Math.abs(exponent) < Constants.eps)
		{
			return res;
		}
		else
		{
			res.setCoeficient(coeficient * exponent);
			res.setExponent(exponent - 1);
			return res;
		}
		/*
		if(Math.abs(coeficient) < Constants.eps)
		{
			System.out.println(res);
			return res;
		}
		if(Math.abs(exponent - 1) < Constants.eps)
		{
			if(Math.abs(exponent) < Constants.eps)
				return res;
			else
			{
				res.setCoeficient(coeficient);
				res.setExponent(exponent - 1);
			}
			
		}
		else
		{
			res.setCoeficient(coeficient * exponent);
			res.setExponent(exponent - 1);
		}
		System.out.println(res);
		*/
	}
	//integration
	public Monom integ()
	{
		Monom res = new Monom(1, 1);
		res.setCoeficient(coeficient / (exponent + 1));
		res.setExponent(exponent + 1);
		return res;
	}
	
	static public Monom sToM(String s) throws MonomParseException
	{
		int flag = 0;
		Monom m = new Monom(0, 0);
		if(s == null)
			return m;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '*')
				continue;
			if(s.charAt(i) == '-')
				continue;
			if(s.charAt(i) == '+')
				continue;
			if(s.charAt(i) == '^')
				continue;
			if(s.charAt(i) == 'x')
				continue;
			if(s.charAt(i) == '.')
				continue;
			if(s.charAt(i) == ' ')
				continue;
			if((int)s.charAt(i) - (int)'0' >= 0 && (int)s.charAt(i) - (int)'0'< 10)
				continue;
			flag = 1;
			throw(new MonomParseException(s.charAt(i)));
		}
		if(flag == 0)
		{
			// parsed string has format coeficient*x^exponent so res[0] = coef, res[1] = x and res[2] = exponent
			String[] res = s.split(Pattern.quote("*"));
			if(res[0] == s)
			{
				try
				{
					m.setCoeficient(Float.parseFloat(res[0]));
				}
				catch(Exception e)
				{
					if(res[0].charAt(0) == '-')
						m.setCoeficient(-1);
					else
						m.setCoeficient(1);
				}
			}
			else
			{
				m.setCoeficient(Float.parseFloat(res[0]));
			}
			res = s.split(Pattern.quote("^"));
			if(res[0] == s)
			{
				if(res[0].charAt(res[0].length() - 1) == 'x')
				{
					m.setExponent(1);
				}
				else
				{
					m.setExponent(0);
				}
				
			}
			else
			{
				m.setExponent(Float.parseFloat(res[1]));
			}	
		}
		
		
		return m;
	}
	
	public String toString()
	{
		String s = "";
		if(coeficient >=0)
			s += "+";
		s += coeficient + "*x^" + exponent;

		return s;
		
	}


	public int compareTo(Monom m1) {

		if(this.getExponent() > m1.getExponent())
			return 1;
		if(this.getExponent() < m1.getExponent())
			return -1;
		return 0;
	}


}