package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class CheckBill extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3,b4;
	JPanel p1,p2,p3;
	JTextField t1,t2,t3,t4;
	Font f1,f2;
	Choice ch1;
	public int price = 0;
	
	CheckBill()
	{
		super("Check Total Bill");
		setLocation(50,10);
		setSize(1100,500);
		
		f1= new Font("Arial",Font.BOLD,25);
		f2= new Font("Arial",Font.BOLD,18);
		
		ch1 = new Choice();
		
		l1 = new JLabel("Check Total Bill");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2 = new JLabel("Username");
		l3 = new JLabel("Name");
		l4 = new JLabel("Email");
		l5 = new JLabel("Address");
		l6 = new JLabel("Price");
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select * from customer";
			
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				ch1.add(rest.getString("username"));
			}
			rest.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		
		b1 = new JButton("InterCity Cab");
		b2 = new JButton("IntraCity Cab");
		b3 = new JButton("Transport");
		b4 = new JButton("Back");
		
		b1.addActionListener(this);
		b1.setBackground(Color.RED);
		b1.setForeground(Color.BLACK);
		
		b2.addActionListener(this);
		b2.setBackground(Color.RED);
		b2.setForeground(Color.BLACK);
		
		b3.addActionListener(this);
		b3.setBackground(Color.RED);
		b3.setForeground(Color.BLACK);
		
		b4.addActionListener(this);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		
		l1.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		ch1.setFont(f2);
		b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
		b4.setFont(f2);
		t1.setFont(f2);
		t2.setFont(f2);
		t3.setFont(f2);
		t4.setFont(f2);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(7,2,10,10));
		
		p2.add(l2);
		p2.add(ch1);
		p2.add(l3);
		p2.add(t1);
		p2.add(l4);
		p2.add(t2);
		p2.add(l5);
		p2.add(t3);
		p2.add(l6);
		p2.add(t4);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/cab_booking/images/bill.png"));
		Image i2 = i1.getImage().getScaledInstance(650, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l7 = new JLabel(i3);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(l7);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
		add(p3,"West");
		
		ch1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				try
				{
					ConnectionClass obj = new ConnectionClass();
					String username = ch1.getSelectedItem();
					
					String q = "select * from customer where username = '"+username+"'";
					
					ResultSet rest = obj.stm.executeQuery(q);
					
					while(rest.next())
					{
						t1.setText(rest.getString("name"));
						t2.setText(rest.getString("email"));
						t3.setText(rest.getString("address"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}		
		);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			price = 0;
			
			String username = ch1.getSelectedItem();
			
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String q = "select price from intercity_cab where username = '"+username+"'";
				
				ResultSet rest = obj.stm.executeQuery(q);
				
				while(rest.next())
				{
					price = price + Integer.parseInt(rest.getString("price"));
				}
				
				t4.setText(price+"");
				rest.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == b2)
		{
			price = 0;
			
			String username = ch1.getSelectedItem();
			
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String q = "select price from intracity_cab where username = '"+username+"'";
				
				ResultSet rest = obj.stm.executeQuery(q);
				
				while(rest.next())
				{
					price = price + Integer.parseInt(rest.getString("price"));
				}
				
				t4.setText(price+"");
				rest.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == b3)
		{
			price = 0;
			
			String username = ch1.getSelectedItem();
			
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String q = "select price from transport_package where username = '"+username+"'";
				
				ResultSet rest = obj.stm.executeQuery(q);
				
				while(rest.next())
				{
					price = price + Integer.parseInt(rest.getString("price"));
				}
				
				t4.setText(price+"");
				rest.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == b4)
		{
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new CheckBill().setVisible(true);
	}

}
