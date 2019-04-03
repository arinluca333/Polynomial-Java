package PT2019.demo.A1;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Screen {

	public Screen()
	{
		start();
	}
	
	private void start()
	{
		JFrame f=new JFrame();
		Font ft = new Font("Monospace", 50, 20);
		
        JLabel l = new JLabel();
        l.setBounds(0, 0, 800, 50);
        l.setText("The format for a polynomial must be: ");
        l.setFont(ft);    
        JLabel l2 = new JLabel("2*x^2 +1*x^2 -2*x^1 -8*x^0 (not necesarilly in ascending or descending order)");
        l2.setBounds(0, 30, 800 ,50);
        l2.setFont(ft);
        JLabel l3 = new JLabel();
        l3.setBounds(10, 345, 800, 50);
        l3.setFont(ft);
        
        JTextField t1 = new JTextField();
        t1.setBounds(10, 100, 500, 50);
        t1.setFont(ft);
        JTextField t2 = new JTextField();
        t2.setBounds(10, 175, 500, 50);
        t2.setFont(ft);
        JTextField t3 = new JTextField();
        t3.setBounds(10, 530, 500, 50);
        t3.setFont(ft);
        
        JButton der1 = new JButton("deriv");
        der1.setBounds(520, 100, 80, 48);
        der1.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
					String s = "";
					try {
						s = Main.deriv(t1.getText(), 1);
					} catch (MonomParseException e) {
						l3.setText(e.toString());
					}
					if(s.length() > 0)
					{
						s = s.substring(1, s.length());
					}
							t1.setText(s + " ");		
			}          
	    });
        
        JButton der2 = new JButton("deriv");    
        der2.setBounds(520, 175, 80, 48);
        der2.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String s = "";
				try {
					s = Main.deriv(t2.getText(), 2);
				} catch (MonomParseException e) {
					l3.setText(e.toString());
				}
				s = s.substring(1, s.length());
						t2.setText(s + " ");		
			}          
	    });
        
        JButton integ1 = new JButton("integ");
        integ1.setBounds(620, 100, 80, 48);
        integ1.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String s = "";
				try {
					s = Main.integ(t1.getText(), 1);
				} catch (MonomParseException e) {
					l3.setText(e.toString());
				}
				s = s.substring(1, s.length());
						t1.setText(s + " ");			
			}          
	    });
        
        JButton integ2 = new JButton("integ");
        integ2.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
						String s = "";
						try {
							s = Main.integ(t2.getText(), 2);
						} catch (MonomParseException e) {
							l3.setText(e.toString());
						}
						s = s.substring(1, s.length());
								t2.setText(s + " ");		
			}          
	    });
        integ2.setBounds(620, 175, 80, 48);
        
        JButton der3 = new JButton("deriv");
        der3.setBounds(520, 530, 80, 48);
        der3.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
						String s = "";
						try {
							s = Main.deriv(t3.getText(), 3);
						} catch (MonomParseException e) {
							l3.setText(e.toString());
						}
						s = s.substring(1, s.length());
								t3.setText(s + " ");		
			}          
	    });
        JButton integ3 = new JButton("integ");
        integ3.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

						String s = "";
						try {
							s = Main.integ(t3.getText(), 3);
						} catch (MonomParseException e) {
							l3.setText(e.toString());
						}
						s = s.substring(1, s.length());
								t3.setText(s + " ");		
			}          
	    });
        integ3.setBounds(620, 530, 80, 48);
        
        
        JButton add = new JButton("add");
        add.setBounds(10, 250, 100, 100);
        add.setFont(ft);
        add.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

						String s = "";
						try {
							s = Main.add(t1.getText(), t2.getText());
						} catch (MonomParseException e1) {
							l3.setText(e1.toString());
						}
						try
						{
							s = s.substring(1, s.length());
						}
						catch(Exception e)
						{
							s = "0";
						}
						t3.setText(s + " ");		
			}          
	    });
        JButton sub = new JButton("sub");
        sub.setBounds(160, 250, 100, 100);
        sub.setFont(ft);
        sub.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
						String s = "";
						try {
							s = Main.sub(t1.getText(), t2.getText());
						} catch (MonomParseException e1) {
							l3.setText(e1.toString());
						}
						try
						{
							s = s.substring(1, s.length());
						}
						catch(Exception e)
						{
							s = "0";
						}
						
						t3.setText(s + " ");	
			}          
	    });
        JButton mul = new JButton("mul");
        mul.setBounds(10, 400, 100, 100);
        mul.setFont(ft);
        mul.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
						String s = "";
						try {
							s = Main.mul(t1.getText(), t2.getText());
						} catch (MonomParseException e) {
							l3.setText(e.toString());
						}
						try
						{
							s = s.substring(1, s.length());
						}
						catch(Exception e)
						{
							s = "0";
						}
						
						t3.setText(s + " ");	
			}          
	    });
        JButton div = new JButton("div");
        div.setBounds(160, 400, 100, 100);
        div.setFont(ft);
        div.addActionListener(new ActionListener() 
        { 
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
						String s = "";
						try {
							s = Main.div(t1.getText(), t2.getText());
						} catch (MonomParseException e) {
							l3.setText(e.toString());
						}
						s = s.substring(1, s.length());
						t3.setText(s + " ");	
			}          
	    });
        
        
        f.add(l3);
        f.add(div);
        f.add(mul);
        f.add(sub);
        f.add(add);
        f.add(integ2);
        f.add(integ1);
        f.add(der1);
        f.add(der2);
        f.add(t2);
        f.add(t1);
        f.add(t3);
        f.add(l);
        f.add(l2);
        f.add(der3);
        f.add(integ3);
		f.setSize(730,650); 
		f.setLayout(null); 
		f.setVisible(true); 
	}
}
