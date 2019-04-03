package PT2019.demo.A1;

import java.util.*;



public class Polinom {

	public ArrayList<Monom> pol = new ArrayList<Monom>();
	
	Polinom()
	{

	}
	
	public int getSize()
	{
		return pol.size();
	}
	
	public void add(Monom m)
	{
		int flag = 1;
		if(this.getSize() != 0)
		{
			for(int i = 0; i < this.getSize(); i++)
			{
				if(Math.abs(pol.get(i).getExponent() - m.getExponent()) < Constants.eps)
				{
					// monom with m.exponent power already exists in polynomial, we add them
					Monom temp =  pol.get(i).add(m);
					pol.remove(i);
					if(Math.abs(temp.getCoeficient()) > Constants.eps)
					{
						pol.add(i, temp);
					}
					flag = 0;
				}
			}
			if(flag == 1)
			{
				// monom m is unique by m.exponent so we add it to the polinom
				if(Math.abs(m.getCoeficient()) > Constants.eps)
					pol.add(m);
			}
		}
		else
		{
			// the polinom is empty so we add the monom if it has a coeficient diffenrent from 0
			if(Math.abs(m.getCoeficient()) > Constants.eps)
				pol.add(m);
		}
		Collections.sort(pol);
	}
	
	public void add(Polinom p2)
	{

		for(int i = 0; i < p2.getSize(); i++)
		{
			this.add(p2.pol.get(i));
		}

	}
	
	public void sub(Monom m)
	{
		int flag = 1; // used to check if while going through the polinom we found a monom with the same power as m
		if(this.getSize() != 0)
		{
			for(int i = 0; i < this.getSize(); i++)
			{
				if(Math.abs(pol.get(i).getExponent() - m.getExponent()) < Constants.eps)
				{
					// monom with m.exponent power already exists in polynomial, we add them
					Monom temp =  pol.get(i).sub(m);
					pol.remove(i);
					// we test if result monom has coeficient so small that we consider it 0 and do not add it
					//to the polynomial
					if(Math.abs(temp.getCoeficient()) > Constants.eps)
						{
							pol.add(i, temp);
						}
					flag = 0;
				}
			}
			if(flag == 1)
			{
				// monom m is unique by m.exponent so we add it to the polynomial
				if(Math.abs(m.getCoeficient()) > Constants.eps)
					pol.add(new Monom(-m.getCoeficient(), m.getExponent()));
			}
		}
		else
		{
			// the polynomial is empty so we add the monom if it has a coeficient diffenrent from 0
			if(Math.abs(m.getCoeficient()) > Constants.eps)
				pol.add(new Monom(-m.getCoeficient(), m.getExponent()));
		}
		Collections.sort(pol);
	}

	public void sub(Polinom p2)
	{
		for(int i = 0; i < p2.getSize(); i++)
		{
			this.sub(p2.pol.get(i));
		}
	}

	public void mul(Monom m)
	{
		for(int i = 0; i < this.getSize(); i++)
		{
			Monom temp = pol.get(i).mul(m);
			pol.remove(i);
			if(Math.abs(temp.getCoeficient()) > Constants.eps)
				{
					pol.add(i, temp);
				}
		}
		Collections.sort(pol);
	}
	
	public void mul(Polinom p2)
	{
		Polinom cpy = new Polinom();
		cpy.add(this);
		System.out.print(cpy);
		this.mul(p2.pol.get(0));
		System.out.println(this);
		for(int i = 1; i < p2.getSize(); i++)
		{
			Polinom x = new Polinom();
			x.add(cpy);
			System.out.println(x);
			x.mul(p2.pol.get(i));
			System.out.println(x);
			this.add(x);
			System.out.println(this);
		}
		Collections.sort(pol);
	}

	public void deriv()
	{
		for(int i = 0; i < this.getSize(); i++)
		{
			Monom temp = new Monom();
			temp = pol.get(i).deriv();
			pol.remove(i);
			if(Math.abs(temp.getCoeficient()) > Constants.eps)
				pol.add(i, temp);
		}
	}
	
	public void integ()
	{
		for(int i = 0; i < this.getSize(); i++)
		{
			Monom temp = new Monom();
			temp = pol.get(i).integ();
			pol.remove(i);
			if(Math.abs(temp.getCoeficient()) > Constants.eps)
				pol.add(i, temp);
		}
	}
	
	public void div(Monom m)
	{
		for(int i = 0; i < this.getSize(); i++)
		{
			Monom temp = pol.get(i).div(m);
			pol.remove(i);
			if(Math.abs(temp.getCoeficient()) > Constants.eps)
				{
					pol.add(i, temp);
				}
		}
		Collections.sort(pol);
	}
	
	public Polinom div(final Polinom p2) 
	{
		return null;
	}
	
	static public Polinom sToP(String s) throws MonomParseException
	{
		Polinom p = new Polinom();
		String[] res = s.split(" ");
		for(int i = 0; i < res.length; i++)
		{
			// every parsed token is a monom
			try 
			{
				p.add(Monom.sToM(res[i]));
			} 
			catch (MonomParseException e)
			{
				throw(e);
			}
		}
		return p;
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < this.getSize(); i++)
		{
			s += " " + pol.get(i).toString();
		}
		return s;
	}
}
