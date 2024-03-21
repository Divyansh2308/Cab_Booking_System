package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class ViewBookedPackage extends JFrame{
	
	Font f;
	JTable t1;
	String x[] = {"Book ID","Username","Name","Driver Name","Source","Destination","Weight","Truck","Distance","Price"};
	String y[][] = new String[20][10];
	int i=0,j=0;
	
	ViewBookedPackage()
	{
		super("All Booked Package");
		setSize(1300,400);
		setLocation(0,10);
		f = new Font("MS UI Gothic",Font.BOLD,17);
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select * from transport_package";
			
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				y[i][j++] = rest.getString("Book ID");
				y[i][j++] = rest.getString("Username");
				y[i][j++] = rest.getString("Name");
				y[i][j++] = rest.getString("Driver Name");
				y[i][j++] = rest.getString("Source");
				y[i][j++] = rest.getString("Destination");
				y[i][j++] = rest.getString("weight");
				y[i][j++] = rest.getString("truck");
				y[i][j++] = rest.getString("distance");
				y[i][j++] = rest.getString("Price");
				
				i++;
				j=0;
			}
			t1 = new JTable(y,x);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		t1.setFont(f);
		t1.setBackground(Color.BLACK);
		t1.setForeground(Color.WHITE);
		
		JScrollPane js = new JScrollPane(t1);
		add(js);
	}
	
	public static void main(String[] args) {
		new ViewBookedPackage().setVisible(true);
	}

}
