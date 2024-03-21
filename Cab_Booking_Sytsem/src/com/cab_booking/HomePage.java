package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class HomePage extends JFrame implements ActionListener
{
	JFrame f;
	JLabel l1;
	JPanel p1,p2;
	
	HomePage()
	{
		f = new JFrame("Home Page");
		f.setBackground(Color.BLACK);
		f.setLayout(null);
		
		
		JMenuBar mb1 = new JMenuBar();
		
		JMenu m1 = new JMenu("CustomerProfile");
		JMenu m2 = new JMenu("IntraCityCab");
		JMenu m3 = new JMenu("InterCityCab");
		JMenu m4 = new JMenu("Transport");
		JMenu m5 = new JMenu("Bill");
		JMenu m6 = new JMenu("Other");
		
		JMenuItem mi1 = new JMenuItem("Add Customer");
		JMenuItem mi2 = new JMenuItem("View Customer");
		JMenuItem mi3 = new JMenuItem("Update Customer");
		JMenuItem mi4 = new JMenuItem("Delete Customer");
		JMenuItem mi5 = new JMenuItem("Book IntraCity Cab");
		JMenuItem mi6 = new JMenuItem("View Booked IntraCity Cab");
		JMenuItem mi7 = new JMenuItem("Book InterCity Cab");
		JMenuItem mi8 = new JMenuItem("View Booked InterCity Cab");
		JMenuItem mi9 = new JMenuItem("Book Package");
		JMenuItem mi10 = new JMenuItem("View Booked Package");
		JMenuItem mi11 = new JMenuItem("Check Bill");
		JMenuItem mi12 = new JMenuItem("About");
		JMenuItem mi13 = new JMenuItem("Exit");
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		m3.add(mi7);
		m3.add(mi8);
		m4.add(mi9);
		m4.add(mi10);
		m5.add(mi11);
		m6.add(mi12);
		m6.add(mi13);
		
		mb1.add(m1);
		mb1.add(m2);
		mb1.add(m3);
		mb1.add(m4);
		mb1.add(m5);
		mb1.add(m6);
		
		mb1.setBounds(0, 0, 900, 20);
		f.add(mb1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/cab_booking/images/homePage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 680, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l2 = new JLabel(i3);
		l2.setBounds(0,20,900,680);
		f.add(l2);
		
		f.getContentPane();
		
		f.setVisible(true);
		f.setSize(900,700);
		f.setLocation(100,30);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String cmnd = ae.getActionCommand();
		
		if(cmnd.equals("Add Customer"))
		{
			new AddCustomer().setVisible(true);
		}
		else if(cmnd.equals("View Customer"))
		{
			new ViewCustomer().setVisible(true);
		}
		else if(cmnd.equals("Update Customer"))
		{
			new UpdateCustomer().setVisible(true);
		}
		else if(cmnd.equals("Delete Customer"))
		{
			new DeleteCustomer().setVisible(true);
		}
		else if(cmnd.equals("Book InterCity Cab"))
		{
			new BookInterCityCab().setVisible(true);
		}
		else if(cmnd.equals("View Booked InterCity Cab"))
		{
			new ViewBookedInterCityCab().setVisible(true);
		}
		else if(cmnd.equals("Book IntraCity Cab"))
		{
			new BookIntraCityCab().setVisible(true);
		}
		else if(cmnd.equals("View Booked IntraCity Cab"))
		{
			new ViewBookedIntraCityCab().setVisible(true);
		}
		else if(cmnd.equals("Book Package"))
		{
			new BookPackage().setVisible(true);
		}
		else if(cmnd.equals("View Booked Package"))
		{
			new ViewBookedPackage().setVisible(true);
		}
		else if(cmnd.equals("Check Bill"))
		{
			new CheckBill().setVisible(true);
		}
		else if(cmnd.equals("About"))
		{
			new About().setVisible(true);
		}
		else if(cmnd.equals("Exit"))
		{
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		new HomePage();
	}

}
