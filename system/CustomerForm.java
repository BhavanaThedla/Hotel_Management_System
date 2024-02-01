package hotel.management.system;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class CustomerForm extends JFrame implements ActionListener{
	
	JTextField tfname,tfage,tfidno,tfcountry,tfdeposit;
	JComboBox cbjob1;
	JRadioButton rbmale,rbfemale;
	Choice croom,cprice1;
	JLabel tfcheckin,cprice,deposit;
	JButton submit,back;
	
	CustomerForm(){
		getContentPane().setBackground(Color.white);
		setBounds(200,100,770,630);
		setLayout(null);
		
		JLabel flname = new JLabel("NEW CUSTOMER FORM");
		flname.setBounds(25,20,250,30);
		flname.setFont(new Font("serif",Font.BOLD,20));
		add(flname);
		
		JLabel name = new JLabel("Full Name");
		name.setBounds(25,70,100,30);
		name.setFont(new Font("serif",Font.PLAIN,18));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(200,70,130,30);
		add(tfname);
		
		JLabel age = new JLabel("Age");
		age.setBounds(25,120,100,30);
		age.setFont(new Font("serif",Font.PLAIN,18));
		add(age);
		
		tfage = new JTextField();
		tfage.setBounds(200,120,130,30);
		add(tfage);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(25,170,100,30);
		gender.setFont(new Font("serif",Font.PLAIN,18));
		add(gender);
		
		 rbmale = new JRadioButton("Male");
		 rbmale.setBounds(200,170,70,30);
		 rbmale.setBackground(Color.white);
		 rbmale.setFont(new Font("serif",Font.PLAIN,14));
		 add(rbmale);
		 
		  rbfemale = new JRadioButton("Female");
		 rbfemale.setBounds(280,170,70,30);
		 rbfemale.setBackground(Color.white);
		 rbfemale.setFont(new Font("serif",Font.PLAIN,14));
		 add(rbfemale);
		 
		 ButtonGroup bg = new ButtonGroup();
		 bg.add(rbmale);
		 bg.add(rbfemale);
		 
		JLabel country = new JLabel("Country");
		country.setBounds(25,220,100,30);
		country.setFont(new Font("serif",Font.PLAIN,18));
		add(country);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(200,220,130,30);
		add(tfcountry);
		
		JLabel id = new JLabel("ID");
		id.setBounds(25,270,100,30);
		id.setFont(new Font("serif",Font.PLAIN,18));
		add(id);
		
		String str1[]= {"Passport","Aadhar Card","Driver Liscence","PanCard"};
		
		cbjob1= new JComboBox(str1);
		cbjob1.setBounds(200,270,130,30);
		add(cbjob1);
		
		JLabel idno = new JLabel("ID Number");
		idno.setBounds(25,320,100,30);
		idno.setFont(new Font("serif",Font.PLAIN,18));
		add(idno);
		
		tfidno = new JTextField();
		tfidno.setBounds(200,320,130,30);
		add(tfidno);
		
		JLabel roomno = new JLabel("Room Number");
		roomno.setBounds(25,370,150,30);
		roomno.setFont(new Font("serif",Font.PLAIN,18));
		add(roomno);
		
		croom = new Choice();
		croom.setBounds(200,370,130,30);
		add(croom);
		
		 deposit = new JLabel("Deposit");
		 deposit.setBounds(25,420,150,30);
		 deposit.setFont(new Font("serif",Font.PLAIN,18));
		add(deposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(200,420,130,30);
		add(tfdeposit);
		
		try {
		Conn c = new Conn();
		String query="select * from room where availability='Available' and status ='Cleaned'";
		ResultSet rs = c.s.executeQuery(query);
		while(rs.next()) {
			croom.add(rs.getString("room"));
			//cprice.setText(rs.getString("price"));
		}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
		
		/*cprice = new JLabel();
		cprice.setBounds(200,420,130,30);
		
		
		add(cprice);*/
        
		
		JLabel checkin = new JLabel("Check-In Time");
		checkin.setBounds(25,470,150,30);
		checkin.setFont(new Font("serif",Font.PLAIN,18));
		add(checkin);
		
		Date x = new Date();
		tfcheckin = new JLabel(""+x);
		tfcheckin.setBounds(200,470,180,30);
		tfcheckin.setFont(new Font("serif",Font.PLAIN,18));
		add(tfcheckin);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(300,30,500,370);
        add(l15);
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(25,520,110,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
    	add(submit);

    	back = new JButton("Back");
    	back.addActionListener(this);
    	back.setBounds(200,520, 110, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
    	add(back);
		
    	setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit){
		try {
		Conn c = new Conn();
        String gender = null;
        
        if(rbmale.isSelected()){ 
           gender = "Male";
        }
        else if(rbfemale.isSelected()){ 
            gender = "Female";
        }
        
        String roomno = croom.getSelectedItem();
        
        /*try {
			Conn c1 = new Conn();
			String rno = croom.getSelectedItem();
			String query="select * from room where room = '"+rno+"'";
			ResultSet rs = c1.s.executeQuery(query);
			while(rs.next()) {
				cprice1.add(rs.getString("price"));
				System.out.print(cprice1.getSelectedItem());
				
				//cprice.setText(rs.getString("price"));
			}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
        */

            String id = (String)cbjob1.getSelectedItem(); 
            String name =  tfname.getText();
            String age =  tfage.getText();
            String gender1 =  gender;
            String country =  tfcountry.getText();
            String idno =  tfidno.getText();
            String time = tfcheckin.getText();
            String deposit = tfdeposit.getText();
            /*String query="select * from room where availability='"+roomno+"'";
    		ResultSet rs = c.s.executeQuery(query);
    		while(rs.next()) {
    			//croom.add(rs.getString("room"));
    			cprice.setText(rs.getString("price"));
    		}
    		cprice = new JLabel();
    		cprice.setBounds(200,420,130,30);
    		add(cprice);
            String price = cprice.getText();*/
            
            
            String q1 = "insert into customer values('"+name+"','"+age+"','"+gender1+"','"+country+"','"+id+"','"+idno+"','"+roomno+"','"+time+"','"+deposit+"')";
            String q2 = "update room set availability = 'Occupied' where room = "+roomno;
            c.s.executeUpdate(q1);
            c.s.executeUpdate(q2);

            JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
        }
        catch(SQLException e1){
        	System.out.println(e1.getMessage());
        }
		}else if(ae.getSource()==back) {
			this.setVisible(false);
			new Reception();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerForm();
	}

}
