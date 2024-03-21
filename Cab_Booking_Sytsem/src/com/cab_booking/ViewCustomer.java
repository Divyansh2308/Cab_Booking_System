package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class ViewCustomer extends JFrame {

	JTable t1;
	String x[] = {"Username","Name","Age","Date of Birth","Address","Phone","Email","Country","Gender","Aadhar"};
	String y[][] = new String [20][10];
	int i=0,j=0;
	
	ViewCustomer()
	{
		super("All Customer Details");
		setSize(1300,400);
		setLocation(0,10);
		
		try
		{
			ConnectionClass obj = new ConnectionClass();
			String q = "select * from customer";
			
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next())
			{
				y[i][j++] = rest.getString("username");
				y[i][j++] = rest.getString("name");
				y[i][j++] = rest.getString("age");
				y[i][j++] = rest.getString("dob");
				y[i][j++] = rest.getString("address");
				y[i][j++] = rest.getString("phone");
				y[i][j++] = rest.getString("email");
				y[i][j++] = rest.getString("country");
				y[i][j++] = rest.getString("gender");
				y[i][j++] = rest.getString("aadhar");
				i++;
				j=0;
			}
			t1 = new JTable(y,x);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		t1.setBackground(Color.BLACK);
		t1.setForeground(Color.WHITE);
		
		JScrollPane js = new JScrollPane(t1);
		add(js);
	}
	
	public static void main(String[] args) {
		new ViewCustomer().setVisible(true);
	}

}
