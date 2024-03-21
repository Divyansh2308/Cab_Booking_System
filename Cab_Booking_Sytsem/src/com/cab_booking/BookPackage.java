package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class BookPackage extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	JButton b1,b2;
	JPanel p1,p2,p3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	Font f1,f2;
	Choice ch1,ch2,ch3,ch4;
	
	BookPackage()
	{
		super("Book Transport Package");
		setLocation(50,10);
		setSize(1100,700);
		
		f1= new Font("Arial",Font.BOLD,25);
		f2= new Font("Arial",Font.BOLD,18);
		
		ch1 = new Choice();
		ch2 = new Choice();
		ch3 = new Choice();
		ch4 = new Choice();
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select source from transport_driver";
			
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				ch1.add(rest.getString("source"));
			}
			rest.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select username from customer";
			
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				ch3.add(rest.getString("username"));
			}
			rest.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		l1 = new JLabel("Book Transport Package");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2 = new JLabel("Book ID");
		l3 = new JLabel("Source");
		l4 = new JLabel("Destination");
		l5 = new JLabel("Username");
		l6 = new JLabel("Name");
		l7 = new JLabel("DriverName");
		l8 = new JLabel("Truck");
		l9 = new JLabel("Destination from");
		l10 = new JLabel("Destination to");
		l11 = new JLabel("Price");
		l12 = new JLabel("Weight");
		l13 = new JLabel("Distance");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		t8.setEditable(false);
		
		b1 = new JButton("Book");
		b2 = new JButton("Back");
		
		b1.addActionListener(this);
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.BLACK);
		
		b2.addActionListener(this);
		b2.setBackground(Color.YELLOW);
		b2.setForeground(Color.BLACK);
		
		Random rm = new Random();
		t1.setText(""+Math.abs(rm.nextInt()%100000));
		t1.setForeground(Color.RED);
		
		l1.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		l8.setFont(f2);
		l9.setFont(f2);
		l10.setFont(f2);
		l11.setFont(f2);
		l12.setFont(f2);
		ch1.setFont(f2);
		ch2.setFont(f2);
		ch3.setFont(f2);
		b1.setFont(f2);
		b2.setFont(f2);
		t1.setFont(f2);
		t2.setFont(f2);
		t3.setFont(f2);
		t4.setFont(f2);
		t5.setFont(f2);
		t6.setFont(f2);
		t7.setFont(f2);
		t8.setFont(f2);
		ch4.setFont(f2);
		l13.setFont(f2);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(13,2,10,10));
		
		p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(ch1);
		p2.add(l4);
		p2.add(ch2);
		p2.add(l5);
		p2.add(ch3);
		p2.add(l6);
		p2.add(t2);
		p2.add(l7);
		p2.add(t3);
		p2.add(l8);
		p2.add(t4);
		p2.add(l9);
		p2.add(t5);
		p2.add(l10);
		p2.add(t6);
		p2.add(l11);
		p2.add(t7);
		p2.add(l12);
		p2.add(ch4);
		p2.add(l13);
		p2.add(t8);
		p2.add(b1);
		p2.add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/cab_booking/images/package.jpg"));
		Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l12 = new JLabel(i3);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(l12);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
		add(p3,"West");
		
		ch3.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				try
				{
					ConnectionClass obj = new ConnectionClass();
					String username = ch3.getSelectedItem();
					
					String q = "select name from customer where username = '"+username+"'";
					
					ResultSet rest = obj.stm.executeQuery(q);
					
					while(rest.next())
					{
						t2.setText(rest.getString("name"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}		
		);
		
		ch1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				ch2.removeAll();
				
				try
				{
					ConnectionClass obj = new ConnectionClass();
					String source = ch1.getSelectedItem();
					
					String q = "select destination from transport_driver where source = '"+source+"'";
					
					ResultSet rest = obj.stm.executeQuery(q);
					
					while(rest.next())
					{
						ch2.add(rest.getString("destination"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}		
		);
		
		ch2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				try
				{
					ConnectionClass obj = new ConnectionClass();
					String source = ch1.getSelectedItem();
					String destination = ch2.getSelectedItem();
					
					String q = "select * from transport_driver where source = '"+source+"' and destination = '"+destination+"'";
					
					ResultSet rest = obj.stm.executeQuery(q);
					
					while(rest.next())
					{
						t3.setText(rest.getString("name"));
						t4.setText(rest.getString("truck"));
						t5.setText(rest.getString("source"));
						t6.setText(rest.getString("destination"));
						t7.setText(rest.getString("price"));
						t8.setText(rest.getString("distance"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}		
		);
		
		ch4.add("0 - 10 KG");
		ch4.add("10 - 50 KG");
		ch4.add("50 - 100 KG");
		ch4.add("100 - 500 KG");
		ch4.add("500 - 1000 KG");
		ch4.add(" > 1000 KG");
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			String bid = t1.getText();
			String username = ch3.getSelectedItem();
			String name = t2.getText();
			String dname = t3.getText();
			String truck = t4.getText();
			String source = t5.getText();
			String destination = t6.getText();
			String price = t7.getText();
			String distance = t8.getText();
			String weight = ch4.getSelectedItem();
			
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String q = "insert into transport_package values ('"+bid+"','"+username+"','"+name+"','"+dname+"','"+source+"','"+destination+"','"+weight+"','"+truck+"','"+distance+"','"+price+"'";
				
				int aa = obj.stm.executeUpdate(q);
				
				if(aa == 1)
				{
					JOptionPane.showMessageDialog(null,"Package Booked Successfully");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please , fill  all details carefully.");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == b2)
		{
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new BookPackage().setVisible(true);
	}
	
}
