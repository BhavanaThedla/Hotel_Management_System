package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Hotel extends JFrame implements ActionListener{
	Hotel(){
		setSize(1066,566);
		setLocation(100,100);
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpeg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1066,566);
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(130,30,1500,100);
		text.setForeground(Color.RED);
		text.setFont(new Font("serif",Font.BOLD,50));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(900,450,120,45);
		next.setBackground(Color.pink);
		next.setForeground(Color.BLACK);
		next.setFont(new Font("serif",Font.PLAIN,18));
		next.addActionListener(this);
		image.add(next);
		setVisible(true);
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(450);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(450);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void actionPerformed(ActionEvent e){
        setVisible(false);
		new Login();
        
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hotel();
	}

}
