package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class AllRoom extends JFrame{
	JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblprice;
	private JLabel lbltype;
	private JLabel lblRoomNumber;
	

	public AllRoom(){
		getContentPane().setBackground(Color.white);
		setBounds(30,120,1100,600);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10,40,500,400);
		add(table);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(520,0,550,550);
        add(l1);
        
        JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    Conn c = new Conn();
					String displayCustomersql = "select * from Room";
					//PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 470, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnNewButton.setBounds(290, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		add(btnNewButton);
		
		
		lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(20, 15, 90, 14);
		add(lblRoomNumber);
		
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(119, 15, 69, 14);
		add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		add(lblCleanStatus);
		
		lblprice = new JLabel("Price");
		lblprice.setBounds(330, 15, 46, 14);
		add(lblprice);
		
		lbltype = new JLabel("Bed Type");
		lbltype.setBounds(417, 15, 76, 14);
		add(lbltype);

		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AllRoom();

	}

}
