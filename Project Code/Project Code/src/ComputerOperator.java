
import java.util.*;


public class ComputerOperator {


    
    private String userName; 
    private String password;
    private String pin;
    private ArrayList<Bill> bill;    
    private ArrayList<Product> product;
    private static ComputerOperator instance;

    private ComputerOperator(){
	
    	}
    
    
    public static synchronized ComputerOperator getObject(){
    	if(instance == null){
    		instance = new ComputerOperator();
    	}
    	return instance;
    }
    
    public ComputerOperator(String userName, String password, String pin){
		super();
		this.userName = userName;
		this.password = password;
		this.pin = pin;
		this.bill = new ArrayList<Bill>();
		this.product =   new ArrayList<Product>();
	
	}

    
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public ArrayList<Bill> getBill() {
		return bill;
	}


	public void setBill(ArrayList<Bill> bill , int position) {
		this.bill = bill;
	}


	public ArrayList<Product> getProduct() {
		return product;
	}


	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}


	public ComputerOperator getInstance() {
		return instance;
	}
	
	public void addproduct(Product p){
		this.product.add(p);
	}
	
	public void addBill(Bill b){
		this.bill.add(b);
	}
	
	public void setInstance(ComputerOperator instance) {
		this.instance = instance;
	}


	public void login(String userName, String password) {


    }



    public void resetPassword(String pin, String password) {
    				

    }

    
    public void changePassword(String pin, String oldPassword, String newPassword) {
       
    }
    
    
    
}