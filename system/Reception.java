package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener{
	
	JButton newCustomer,rooms,department,allemployee,customers,checkout,pendingstatus,roomstatus,pickup,searchroom,logout;

	Reception(){
		getContentPane().setBackground(Color.white);
		setBounds(300,80,800,640);
		setLayout(null);
		
		
		newCustomer = new JButton("New Customer Form");
		newCustomer.setBounds(20,20,150,30);
		newCustomer.setBackground(Color.black);
		newCustomer.setForeground(Color.white);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms = new JButton("Rooms");
		rooms.setBounds(20,70,150,30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);
		
		
		allemployee = new JButton("All Employee");
		allemployee.setBounds(20,120,150,30);
		allemployee.setBackground(Color.black);
		allemployee.setForeground(Color.white);
		allemployee.addActionListener(this);
		add(allemployee);

		
		customers = new JButton("Customer");
		customers.setBounds(20,170,150,30);
		customers.setBackground(Color.black);
		customers.setForeground(Color.white);
		customers.addActionListener(this);
		add(customers);
		
				
		checkout = new JButton("CheckOut");
		checkout.setBounds(20,220,150,30);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		pickup = new JButton("PickUp Service");
		pickup.setBounds(20,270,150,30);
		pickup.setBackground(Color.black);
		pickup.setForeground(Color.white);
		pickup.addActionListener(this);
		add(pickup);
		
		pendingstatus = new JButton("Pending Status");
		pendingstatus.setBounds(20,320,150,30);
		pendingstatus.setBackground(Color.black);
		pendingstatus.setForeground(Color.white);
		pendingstatus.addActionListener(this);
		add(pendingstatus);
		
		roomstatus = new JButton("Room Status");
		roomstatus.setBounds(20,370,150,30);
		roomstatus.setBackground(Color.black);
		roomstatus.setForeground(Color.white);
		roomstatus.addActionListener(this);
		add(roomstatus);
		
		searchroom = new JButton("Search Rooms");
		searchroom.setBounds(20,420,150,30);
		searchroom.setBackground(Color.black);
		searchroom.setForeground(Color.white);
		searchroom.addActionListener(this);
		add(searchroom);
		
		logout = new JButton("Log Out");
		logout.setBounds(20,470,150,30);
		logout.setBackground(Color.RED);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250,30,500,470);
        add(l1);
		
        setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==newCustomer) {
			setVisible(false);
			new CustomerForm();
		}
		else if(ae.getSource()==rooms) {
			setVisible(false);
			new AllRoom();
		}
		else if(ae.getSource()==allemployee) {
			setVisible(false);
			new EmployeeInfo();
		}
		else if(ae.getSource()==customers) {
			setVisible(false);
			try {
				new CustomerInfo();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==checkout) {
			setVisible(false);
			try {
				new Checkout().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==pickup) {
			setVisible(false);
			try {
				new PickUp().setVisible(true);;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==pendingstatus) {
			setVisible(false);
			try {
				new UpdateCheck().setVisible(true);;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==roomstatus) {
			setVisible(false);
			try {
				new UpdateRoom();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==searchroom) {
			setVisible(false);
			try {
				new SearchRoom().setVisible(true);;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==logout) {
			setVisible(false);
			new Daashboard();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Reception();
	}

}
