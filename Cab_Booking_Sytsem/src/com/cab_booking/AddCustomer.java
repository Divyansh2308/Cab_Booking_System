package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddCustomer extends JFrame implements ActionListener{

	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;		
	
	AddCustomer()
	{
		f= new JFrame("Add Customer");
		f.setBackground(Color.WHITE);
		f.setLayout(null);
		
		l1 = new JLabel("New Customer Details");
		l1.setBounds(280,20,500,50);
		l1.setFont(new Font("Airal",Font.BOLD,30));
		l1.setForeground(Color.black);
		f.add(l1);
		
		l2 = new JLabel("Username");
		l2.setBounds(50,150,150,30);
		l2.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(200,150,150,30);
		f.add(t1);
		
		l3 = new JLabel("Name");
		l3.setBounds(450,150,150,30);
		l3.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l3);
		
		t2 = new JTextField();
		t2.setBounds(600,150,150,30);
		f.add(t2);
		
		l4 = new JLabel("Age");
		l4.setBounds(50,200,150,30);
		l4.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l4);
		
		t3 = new JTextField();
		t3.setBounds(200,200,150,30);
		f.add(t3);
		
		l5 = new JLabel("Date of Birth");
		l5.setBounds(450,200,150,30);
		l5.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l5);
		
		t4 = new JTextField();
		t4.setBounds(600,200,150,30);
		f.add(t4);
		
		l6 = new JLabel("Address");
		l6.setBounds(50,250,150,30);
		l6.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l6);
		
		t5 = new JTextField();
		t5.setBounds(200,250,150,30);
		f.add(t5);
		
		l7 = new JLabel("Phone");
		l7.setBounds(450,250,150,30);
		l7.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l7);
		
		t6 = new JTextField();
		t6.setBounds(600,250,150,30);
		f.add(t6);
		
		l8 = new JLabel("Email Id");
		l8.setBounds(50,300,150,30);
		l8.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l8);
		
		t7 = new JTextField();
		t7.setBounds(200,300,150,30);
		f.add(t7);
		
		l9 = new JLabel("Country");
		l9.setBounds(450,300,150,30);
		l9.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l9);
		
		t8 = new JTextField();
		t8.setBounds(600,300,150,30);
		f.add(t8);
		
		l10 = new JLabel("Gender");
		l10.setBounds(50,350,150,30);
		l10.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l10);
		
		t9 = new JTextField();
		t9.setBounds(200,350,150,30);
		f.add(t9);
		
		l11 = new JLabel("Aadhar No.");
		l11.setBounds(450,350,150,30);
		l11.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l11);
		
		t10 = new JTextField();
		t10.setBounds(600,350,150,30);
		f.add(t10);
		
		b1 = new JButton("Submit");
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.addActionListener(this);
		
		b1.setBackground(Color.RED);
		b1.setForeground(Color.BLACK);
		
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b1.setBounds(250,500,150,40);
		b2.setBounds(450,500,150,40);
		
		f.add(b1);
		f.add(b2);
		
		f.getContentPane();
		
		f.setVisible(true);
		f.setSize(900,600);
		f.setLocation(300,100);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			String username = t1.getText();
			String name = t2.getText();
			String age = t3.getText();
			String dob = t4.getText();
			String address = t5.getText();
			String phone = t6.getText();
			String email = t7.getText();
			String country = t8.getText();
			String gender = t9.getText();
			String aadhar = t10.getText();
			
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String q = "insert into customer values ('"+username+"','"+name+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+country+"','"+gender+"','"+aadhar+"')";
				
				int aa = obj.stm.executeUpdate(q);
				
				if(aa == 1)
				{
					JOptionPane.showMessageDialog(null, " Customer Successfully Added");
					f.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Please fill details carefully.");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if(ae.getSource() == b2)
		{
			f.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer();
	}
}
