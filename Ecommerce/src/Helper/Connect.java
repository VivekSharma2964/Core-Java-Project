package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
public static Connection con=null;
public static Connection getConnection() {
	try {
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","root");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
}
