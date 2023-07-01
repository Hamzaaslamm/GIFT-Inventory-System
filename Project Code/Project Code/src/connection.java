import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class connection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/gift";
			String uid = "root";
			String passwd = "";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uid, passwd); 
		
			
		}
		
		catch(Exception e){
			
			System.out.println(e);
		}
	}

}
