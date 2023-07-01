
import java.util.*;

public class OrderLine {
	
    private String pName;
    private int pQuantity;
    private double pPrice;    
    private double pAmount;
    
    public OrderLine() {
    }
    
    public OrderLine(String pName, int pQuantity, double pPrice, double pAmount) {
		super();
		this.pName = pName;
		this.pQuantity = pQuantity;
		this.pPrice = pPrice;
		this.pAmount = pAmount;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getpQuantity() {
		return pQuantity;
	}


	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public double getpAmount() {
		return pAmount;
	}

	public void setpAmount(double pAmount) {
		this.pAmount = pAmount;
	}

	public void addOrderLine(String pName, int pQuantity, double pPrice, double pAmount) {
     
    }
   
    public void addOrderLine() {
       
    }

}