import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;

public class run {

	public static void main(String[] args)  throws FileNotFoundException, SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/gift";
			 String uid = "root";
			String passwd = "";
			Connection con;
			
			
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, uid, passwd); 
				Statement stmt = con.createStatement();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter the name");
			String name = input.nextLine();
			System.out.println("Enter the Amount");
			int amount = input.nextInt();
			System.out.println("Enter the Discount");
			double discount = input.nextDouble();
			
			System.out.println("Enter the Date");
			String  date = input.next();
			
			System.out.println("Enter the username");
			String username = input.next();
			Statement s = con.createStatement();
			String query = "INSERT INTO `product`( `pid`, `Product_Name`, `pQuantity`, `pprice`, `pDescription`, `FkP_User_Name`) VALUES ('Lays','7895.3','5','12/12/2002','username')";
			s.executeUpdate(query);
			
	con.close();
	s.close();
		
		

	}

}
