package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class UpdateCustomer extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b1,b2;
	JPanel p1,p2,p3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	Font f1,f2;
	Choice ch;
	
	UpdateCustomer()
	{
		super("Update Customer");
		setSize(740,700);
		setLocation(50,50);
		
		f1 = new Font("Arial",Font.BOLD,25);
		f2 = new Font("Arial",Font.BOLD,18);
		
		ch = new Choice();
		
		try 
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select username from customer";
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				ch.add(rest.getString("username"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		l1 = new JLabel("Update Customer");
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		l2 = new JLabel("Username");
		l3 = new JLabel("Name");
		l4 = new JLabel("Age");
		l5 = new JLabel("DOB");
		l6 = new JLabel("Address");
		l7 = new JLabel("Phone");
		l8 = new JLabel("Email");
		l9 = new JLabel("Country");
		l10 = new JLabel("Gender");
		l11 = new JLabel("Aadhar");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		t9 = new JTextField();
		
		b1 = new JButton("Update");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
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
		t1.setFont(f2);
		t2.setFont(f2);
		t3.setFont(f2);
		t4.setFont(f2);
		t5.setFont(f2);
		t6.setFont(f2);
		t7.setFont(f2);
		t8.setFont(f2);
		t9.setFont(f2);
		ch.setFont(f2);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(11,2,10,10));
		p2.add(l2);
		p2.add(ch);
		p2.add(l3);
		p2.add(t1);
		p2.add(l4);
		p2.add(t2);
		p2.add(l5);
		p2.add(t3);
		p2.add(l6);
		p2.add(t4);
		p2.add(l7);
		p2.add(t5);
		p2.add(l8);
		p2.add(t6);
		p2.add(l9);
		p2.add(t7);
		p2.add(l10);
		p2.add(t8);
		p2.add(l11);
		p2.add(t9);
		p2.add(b1);
		p2.add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/cab_booking/images/update2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(350, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		l12 = new JLabel(i3);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(l12);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
		add(p3,"West");
		
		ch.addMouseListener(new MouseAdapter()
		{		
				public void mouseClicked(MouseEvent me)
				{
					try
					{
						ConnectionClass obj2 = new ConnectionClass();
						String username = ch.getSelectedItem();
						String q1 = "select * from customer where username ='"+username+"'";
						
						ResultSet rest1 = obj2.stm.executeQuery(q1);
						
						while(rest1.next())
						{
							t1.setText(rest1.getString("name"));
							t2.setText(rest1.getString("age"));
							t3.setText(rest1.getString("dob"));
							t4.setText(rest1.getString("address"));
							t5.setText(rest1.getString("phone"));
							t6.setText(rest1.getString("email"));
							t7.setText(rest1.getString("country"));
							t8.setText(rest1.getString("gender"));
							t9.setText(rest1.getString("aadhar"));
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}								
		});
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			String username = ch.getSelectedItem();
			String name = t1.getText();
			String age = t2.getText();
			String dob = t3.getText();
			String address = t4.getText();
			String phone = t5.getText();
			String email = t6.getText();
			String country = t7.getText();
			String gender = t8.getText();
			String aadhar = t9.getText();
			
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String q = "update customer set name = '"+name+"',age = '"+age+"',dob = '"+dob+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',country = '"+country+"',gender = '"+gender+"',aadhar = '"+aadhar+"' where username = '"+username+"'";
				
				int aa = obj.stm.executeUpdate(q);
				
				if(aa == 1)
				{
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill details carefully");
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
		new UpdateCustomer().setVisible(true);
	}
}