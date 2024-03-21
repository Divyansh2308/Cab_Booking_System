package com.cab_booking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame{

	JLabel l1;
	JLabel l2;
	Font f;
	JPanel p;
	
	About()
	{
		super("About");
		setSize(500,300);
		setLocation(400,300);
		
		f = new Font("Arial",Font.BOLD,15);
		
		l1 = new JLabel("Project -- Cab Management System");
		l2 = new JLabel("Made By -- Divyansh Bansal");
		
		l1.setFont(f);
		l2.setFont(f);
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2.setHorizontalAlignment(JLabel.CENTER);
		
		p = new JPanel();
		p.setLayout(new GridLayout(2,1,10,10));
		p.add(l1);
		p.add(l2);
		
		add(p,"Center");
		
	}
	
	public static void main(String[] args) {
		new About().setVisible(true);
	}

}
