package PT2019.demo.A1;

import java.util.ArrayList;

import junit.framework.*;
public class MainTest extends TestCase 
{
	 public Polinom p1 = new Polinom();
	 public Polinom p2 = new Polinom();
	 Monom m1 = new Monom(1, 2);
	 Monom m2 = new Monom(2, 3);
	 Monom m3 = new Monom(3, 3);
	 Monom m4 = new Monom(1, 5);
	
	 // setarea valorilor n1, n2
	 public void setUp()
	 {
		 p1.add(m1);
		 p1.add(m2);
		 p2.add(m3);
		 p2.add(m4);
		
		 System.out.println("setUp:\n p1: " + p1 + "\n p2: " + p2);
	 }
	 // operatii cu cele doua valori
	 public void testAdd()
	 {
		 Polinom p3 = new Polinom();
		 p3 = p1;
		 p3.add(p2);
		 System.out.println(p3.toString());
		 ArrayList<Monom> p = new ArrayList<Monom>();
		 p.add(new Monom(1, 2));
		 p.add(new Monom(5, 3));
		 p.add(new Monom(1, 5));

		 int flag = 1;
		 for(int i = 0; i < p3.getSize(); i++)
		 {
			 if(p3.pol.get(i).getCoeficient() != p.get(i).getCoeficient() || p3.pol.get(i).getExponent() != p.get(i).getExponent())
				 {
				 	flag = 0;

				 }
		 }
		 assertTrue(flag == 1);
	 }
	
	 public void testSub()
	 {
		 Polinom p3 = new Polinom();
		 p3 = p1;
		 p3.sub(p2);
		 ArrayList<Monom> p = new ArrayList<Monom>();
		 p.add(new Monom(1, 2));
		 p.add(new Monom(-1, 3));
		 p.add(new Monom(-1, 5));
		 int flag = 1;
		 System.out.println(p3);
		 for(int i = 0; i < p3.getSize(); i++)
		 {
			 if(p3.pol.get(i).getCoeficient() != p.get(i).getCoeficient() || p3.pol.get(i).getExponent() != p.get(i).getExponent())
				 {
				 	flag = 0;

				 }
		 }
		 assertTrue(flag == 1);
	 }
	
	 public void testMul()
	 {
		 Polinom p3 = new Polinom();
		 p3 = p1;
		 p3.mul(p2);
		 System.out.println(p3);
		 ArrayList<Monom> p = new ArrayList<Monom>();
		 p.add(new Monom(3, 5));
		 p.add(new Monom(6, 6));
		 p.add(new Monom(1, 7));
		 p.add(new Monom(2, 8));
		 int flag = 1;
		 for(int i = 0; i < p3.getSize(); i++)
		 {
			 if(p3.pol.get(i).getCoeficient() != p.get(i).getCoeficient() || p3.pol.get(i).getExponent() != p.get(i).getExponent())
				 {
				 	flag = 0;

				 }
		 }
		 assertTrue(flag == 1);
	 }

	 //metoda rulata dupa executarea testelor
	 public void tearDown()
	 {
		 p1 = new Polinom();
		 p2 = new Polinom();
		 System.out.println("tearDown:\n p1: " + p1 + "\n p2: " + p2);
	 }
} 