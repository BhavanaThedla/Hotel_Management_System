package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	
	Login(){
		 getContentPane().setBackground(Color.WHITE);
		 setLayout(null);
		 
		 JLabel user = new JLabel("User Name");
		 user.setBounds(40,20,100,30);
		 user.setFont(new Font("serif",Font.PLAIN,15));
		 add(user);
		 
		  username = new JTextField();
		 username.setBounds(150,20,150,30);
		 add(username);
		 
		 JLabel pass = new JLabel("Password");
		 pass.setBounds(40,70,100,30);
		 pass.setFont(new Font("serif",Font.PLAIN,15));
		 add(pass);
		 
		  password = new JPasswordField();
		 password.setBounds(150,70,150,30);
		 add(password);
		 
		  login = new JButton("Login");
		 login.setBounds(40,150,120,30);
		 login.setBackground(Color.black);
		 login.setForeground(Color.white);
		 login.addActionListener(this);
		 add(login);
		 
		  cancel = new JButton("Cancel");
		 cancel.setBounds(180,150,120,30);
		 cancel.setBackground(Color.black);
		 cancel.setForeground(Color.white);
		 cancel.addActionListener(this);
		 add(cancel);
		 
		 ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image= new JLabel(i3);
		 image.setBounds(300,10,150,150);
		 add(image);
		 
		 setBounds(450,120,500,300);
		 setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			String u = username.getText();
			String v = password.getText();
			try {
				Conn c = new Conn();
				 String q = "select * from login where username='"+u+"' and password='"+v+"'";
				 ResultSet rs = c.s.executeQuery(q);
				 if(rs.next()) {
					 setVisible(false);
					 new Daashboard();
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Invalid Username or Password");
					 
				 }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==cancel) {
			setVisible(false);
			new Hotel();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
