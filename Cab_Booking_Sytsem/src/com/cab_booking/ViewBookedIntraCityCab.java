package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class ViewBookedIntraCityCab extends JFrame{
	
	Font f;
	JTable t1;
	String x[] = {"Book ID","Username","Driver Name","Car","Source","Destination","Price"};
	String y[][] = new String[20][7];
	int i=0,j=0;
	
	ViewBookedIntraCityCab()
	{
		super("All IntraCity Booked Cab");
		setSize(1300,400);
		setLocation(0,10);
		f = new Font("MS UI Gothic",Font.BOLD,17);
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select * from intracity_cab";
			
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				y[i][j++] = rest.getString("Book ID");
				y[i][j++] = rest.getString("Username");
				y[i][j++] = rest.getString("Driver Name");
				y[i][j++] = rest.getString("Car");
				y[i][j++] = rest.getString("Source");
				y[i][j++] = rest.getString("Destination");
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
		new ViewBookedIntraCityCab().setVisible(true);
	}

}
