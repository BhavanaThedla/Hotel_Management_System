package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfname,tfage,tfsalary,tfmail,tfphone,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JComboBox cbjob;
	AddEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(250,100,850,540);
		
		
		JLabel name = new JLabel("Name");
		name.setBounds(60, 30, 120, 30);
		name.setFont(new Font("serif", Font.PLAIN,19));
		add(name);
		
		  tfname = new JTextField();
		 tfname.setBounds(200,30,150,30);
		 add(tfname);
		 
		 JLabel age = new JLabel("Age");
		 age.setBounds(60, 80, 120, 30);
		 age.setFont(new Font("serif", Font.PLAIN,19));
		 add(age);
			
		  tfage = new JTextField();
		 tfage.setBounds(200,80,150,30);
		 add(tfage);
		 
		 JLabel gender = new JLabel("Gender");
		 gender.setBounds(60, 130, 120, 30);
		 gender.setFont(new Font("serif", Font.PLAIN,19));
		 add(gender);
		 
		  rbmale = new JRadioButton("Male");
		 rbmale.setBounds(200,130,70,30);
		 rbmale.setBackground(Color.white);
		 rbmale.setFont(new Font("serif",Font.PLAIN,14));
		 add(rbmale);
		 
		  rbfemale = new JRadioButton("Female");
		 rbfemale.setBounds(280,130,70,30);
		 rbfemale.setBackground(Color.white);
		 rbfemale.setFont(new Font("serif",Font.PLAIN,14));
		 add(rbfemale);
		 
		 ButtonGroup bg = new ButtonGroup();
		 bg.add(rbmale);
		 bg.add(rbfemale);
		 
		 JLabel job = new JLabel("Job");
		 job.setBounds(60, 180, 120, 30);
		 job.setFont(new Font("serif", Font.PLAIN,19));
		 add(job);
		 
		 String[] str = {"Front-Desk","Clerks","Chefs","Waiter/Waitress","Room Service","Driver","Manager"};
		  cbjob = new JComboBox(str);
		 cbjob.setBounds(200,180,150,30);
		 cbjob.setBackground(Color.white);
		 add(cbjob);
		 
		 JLabel salary = new JLabel("Salary");
		 salary.setBounds(60,230, 120, 30);
		 salary.setFont(new Font("serif", Font.PLAIN,19));
		 add(salary);
			
		  tfsalary = new JTextField();
		 tfsalary.setBounds(200,230,150,30);
		 add(tfsalary);
		 
		 JLabel phone = new JLabel("Mobile");
		 phone.setBounds(60,280, 120, 30);
		 phone.setFont(new Font("serif", Font.PLAIN,19));
		 add(phone);
			
		  tfphone = new JTextField();
		 tfphone.setBounds(200,280,150,30);
		 add(tfphone);
		 
		 JLabel mail = new JLabel("E-mail");
		 mail.setBounds(60,330, 120, 30);
		 mail.setFont(new Font("serif", Font.PLAIN,19));
		 add(mail);
			
		 tfmail = new JTextField();
		 tfmail.setBounds(200,330,150,30);
		 add(tfmail);
		 
		 JLabel aadhar = new JLabel("Aadhar");
		 aadhar.setBounds(60,380, 120, 30);
		 aadhar.setFont(new Font("serif", Font.PLAIN,19));
		 add(aadhar);
			
		  tfaadhar = new JTextField();
		 tfaadhar.setBounds(200,380,150,30);
		 add(tfaadhar);
		 
		 JButton submit = new JButton("Submit");
		 submit.setBounds(200,430,150,30);
		 submit.setBackground(Color.black);
		 submit.setForeground(Color.white);
		 submit.addActionListener(this);
		 add(submit);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(380,60,450,370);
		 add(image);
		 
		 setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String mail = tfmail.getText();
		String aadhar = tfaadhar.getText();
		String gender = null;
		if(rbmale.isSelected()) {
			gender = "Male";
		}else if(rbfemale.isSelected()) {
			gender = "Female";
		}
		
		String job = (String)cbjob.getSelectedItem();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name should not be empty");
			return;
		}
		
		try {
            Conn c = new Conn();
            String str = "INSERT INTO addemployee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+mail+"', '"+aadhar+"')";
            
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Employee Added");
            setVisible(false);
        
        } catch (Exception e) {
            e.printStackTrace();
    }
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddEmployee();

	}

}
