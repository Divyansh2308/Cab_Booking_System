package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
// java.util.*;

public class Login extends JFrame implements ActionListener
{
	JPanel p;
	JFrame f;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField pf1;
	JButton b1,b2;
	
	Login()
	{
		f = new JFrame("Login Page");
		f.setBackground(Color.WHITE);
		f.setLayout(null);
		
		l1 = new JLabel("Login");
		l1.setBounds(110,10,140,40);
		l1.setFont(new Font("Airal",Font.BOLD,30));
		f.add(l1);
		
		l2 = new JLabel("Username");
		l2.setBounds(40, 70, 100, 30);
		f.add(l2);
		
		l3 = new JLabel("Password");
		l3.setBounds(40, 120, 100, 30);
		f.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(150, 70, 150, 30);
		f.add(t1);
		
		pf1 = new JPasswordField();
		pf1.setBounds(150,120, 150, 30);
		f.add(pf1);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,190,120,30);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("SignUp");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(180,190,120,30);
		b2.addActionListener(this);
		f.add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/cab_booking/images/login.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l4 = new JLabel(i3);
		l4.setBounds(300,20,200,200);
		f.add(l4);
		
		f.getContentPane();
		
		f.setVisible(true);
		f.setSize(500,300);
		f.setLocation(400,300);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			try
			{
				ConnectionClass obj = new ConnectionClass();
				String username = t1.getText();
				String pass = pf1.getText();
				
				String q = "select * from signup where username='"+username+"' and password='"+pass+"'";
				
				ResultSet rest = obj.stm.executeQuery(q);
				
				if(rest.next())
				{
					new HomePage().setVisible(true);
					f.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"You have entered wrong details.");
					f.setVisible(false);
					f.setVisible(true);
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
			new SignUp().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
