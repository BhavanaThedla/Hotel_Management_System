package hotel.management.system;
import java.sql.*;
public class Conn {
	
	Connection c;
	Statement s;
	Conn(){
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Indhu@408");
			s=c.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private Statement createstatement() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
