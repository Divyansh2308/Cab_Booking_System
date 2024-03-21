package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddIntraCityDriver extends JFrame implements ActionListener {

	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2;
	JPanel p1,p2;
	JTextField t1,t2,t3,t4,t5;
	Font f1,f2;
	
	AddIntraCityDriver()
	{
		super("Add IntraCity Driver");
		setLocation(450,50);
		setSize(450,400);
		
		f1 = new Font("Arial",Font.BOLD,20);
		f2 = new Font("Arial",Font.BOLD,15);
		
		l1 = new JLabel("Add IntraCity Driver");
		l2 = new JLabel("Driver Name");
		l3 = new JLabel("Source");
		l4 = new JLabel("Destination");
		l5 = new JLabel("Car");
		l6 = new JLabel("Price");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		
		b1 = new JButton("Add");
		b1.addActionListener(this);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		
		l1.setFont(f1);
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		p1 =new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		
		p2 =new JPanel();
		p2.setLayout(new GridLayout(6,2,10,10));
		
		l2.setFont(f2);
		t1.setFont(f2);
		l3.setFont(f2);
		t2.setFont(f2);
		l4.setFont(f2);
		t3.setFont(f2);
		l5.setFont(f2);
		t4.setFont(f2);
		l6.setFont(f2);
		t5.setFont(f2);
		
		p1.add(l1);
		p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(t2);
		p2.add(l4);
		p2.add(t3);
		p2.add(l5);
		p2.add(t4);
		p2.add(l6);
		p2.add(t5);
		p2.add(b1);
		p2.add(b2);
		
		setLayout(new BorderLayout(10,10));
		add(p1,"North");
		add(p2,"Center");
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
			String name = t1.getText();
			String source = t2.getText();
			String destination = t3.getText();
			String car = t4.getText();
			String price = t5.getText();
			
			try {
				
				ConnectionClass obj = new ConnectionClass();
				String q = "insert into intracity_driver values ('"+name+"','"+source+"','"+destination+"','"+car+"','"+price+"')";
				
				int aa = obj.stm.executeUpdate(q);
				
				if(aa == 1)
				{
					JOptionPane.showMessageDialog(null, " Your Data Successfully Inserted");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Please fill all details correctly.");
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
			new AdminSection().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new AddIntraCityDriver().setVisible(true);
	}

}
