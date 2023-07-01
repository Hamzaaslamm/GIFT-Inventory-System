import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBmanager {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/gift";
	private String uid = "root";
	private String passwd = "";

	public void selectRecords() {
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uid, passwd); 
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from bill");
			System.out.println("Bill_id\t\tC_Name\t\tAmount\t\tDiscount\tDate\t\tUSer name");
			while(result.next()) {
				
				System.out.print(result.getInt(1) +"\t\t");
				System.out.print(result.getString(2) +"\t\t");
				System.out.print( result.getInt(3)+"\t\t");
				System.out.print( result.getInt(4)+"\t\t");

				System.out.print( result.getString(5)+"\t\t");

				System.out.print( result.getString(6)+"\t\t");
				System.out.println();
			}
		}
		
		catch(Exception e){
			
			System.out.println(e);
		}
	}
	
}
