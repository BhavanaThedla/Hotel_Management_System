package hotel.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Daashboard extends JFrame implements ActionListener{
	
	JMenuItem addemployee,addrooms,adddriver,reception;
	Daashboard(){
		setSize(1950,1090);
		setLocation(0,0);
		//setBounds(0,0,1950,1100);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1950, 1100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1950, 1100);
		add(image);
		
		JLabel text = new JLabel("TAJ GROUP WELCOMES YOU");
		text.setBounds(400, 80, 1000, 50);
		text.setForeground(Color.green);
		text.setFont(new Font("serif",Font.BOLD,46));
		image.add(text);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1950, 30);
		image.add(mb);
		
		JMenu hotel = new JMenu("Hotel Management");
		hotel.setForeground(Color.red);
		mb.add(hotel);
		
		JMenu admin = new JMenu("Admin");
		admin.setForeground(Color.blue);
		mb.add(admin);
		
		 reception = new JMenuItem("Reception");
		reception.setBackground(Color.white);
		reception.setForeground(Color.DARK_GRAY);
		reception.addActionListener(this);
		hotel.add(reception);
		
		 addemployee = new JMenuItem("Add Employee");
		addemployee.setBackground(Color.white);
		addemployee.setForeground(Color.DARK_GRAY);
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		 adddriver = new JMenuItem("Add Driver");
		adddriver.setBackground(Color.white);
		adddriver.setForeground(Color.DARK_GRAY);
		adddriver.addActionListener(this);
		admin.add(adddriver);
		
		 addrooms = new JMenuItem("Add Rooms");
		addrooms.setBackground(Color.white);
		addrooms.setForeground(Color.DARK_GRAY);
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addemployee) {
			new AddEmployee();
		}
		else if(ae.getSource()==addrooms) {
			//setVisible(false);
			new AddRoom();
		}
		else if(ae.getSource()==adddriver) {
			new AddDriver();
		}
		else if(ae.getSource()==reception) {
			setVisible(false);
			new Reception();
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Daashboard();
	}

}
