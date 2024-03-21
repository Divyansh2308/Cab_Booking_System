package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AdminSection extends JFrame implements ActionListener{

	JLabel l1;
	JButton b1,b2,b3,b4;
	JPanel p1,p2;
	
	AdminSection()
	{
		super("Admin Section");
		setLocation(450,250);
		setSize(400,270);
		
		l1 = new JLabel("Admin Section");
		l1.setFont(new Font("Arial",Font.BOLD,30));
		
		b1 = new JButton("InterCity Driver");
		b1.addActionListener(this);
		
		b2 = new JButton("IntraCity Driver");
		b2.addActionListener(this);
		
		b3 = new JButton("Transport Driver");
		b3.addActionListener(this);
		
		b4 = new JButton("SignUp");
		b4.addActionListener(this);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5,1,10,10));
		
		p1.add(l1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"Center");
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			new AddInterCityDriver().setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource() == b2)
		{
			new AddIntraCityDriver().setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource() == b3)
		{
			new AddTransportDriver().setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource() == b4)
		{
			new SignUp().setVisible(true);
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new AdminSection().setVisible(true);
	}

}
