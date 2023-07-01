import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.*;


public class Product {
    
	
	
	
    private String pname;
    private String pdescription;   
    private int pquantity;
    private double pprice;

    public Product() {
    }
    
    public Product(String pname, String pdescription, int pquantity, double pprice) {
		super();
		this.pname = pname;
		this.pdescription = pdescription;
		this.pquantity = pquantity;
		this.pprice = pprice;
	}
 
    
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public double getPprice() {
		return pprice;
	}


	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public void addProduct(String pname, String pDescription, int pquantity, double pprice) {
       try{
    	   
		if(pquantity>0){
    	   if(pprice > 0){
    		   if(pname.equals("SELECT `Product_Name` FROM `product` WHERE Product_Name LIKE 'Rani juice';"));
    		   
    	   }
       }
       }Catch (Exception e){
    	   
    	   
       }
       
       
       
		
    }

    
    public void updateStock(int id, String pname, String pDescription, int pquantity, double pprice) {
      
    }

   
    public void deleteProduct(String pname) {
  
    }

  
    public void searchProduct(String pname) {
    	
    	
    	
 
    }

    public void viewProductList() {
    	
    
       
    }

}