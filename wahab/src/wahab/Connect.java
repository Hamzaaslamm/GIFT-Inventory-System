package wahab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connect {
	static Connection con;

		public static void openConnection() {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift", "root", ""); 
			}
			
			catch(Exception e){
				
				System.out.println(e);
			}
		}
		public static void closeConnection() throws SQLException {
			con.close();
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openConnection();
	}
}
