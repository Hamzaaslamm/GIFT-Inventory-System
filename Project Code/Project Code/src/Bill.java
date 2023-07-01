
import java.util.*;

public class Bill {

   


    private String cName;
    private String date;
    private double discount;
    private double amount;
    private ArrayList<OrderLine> orderLine =  new ArrayList<OrderLine>();

    
    
    
    
    public Bill(String cName, String date, double discount, double amount) {
		super();

		this.cName = cName;
		this.date = date;
		this.discount = discount;
		this.amount = amount;
		this.orderLine = new ArrayList<OrderLine>();
	}
	public Bill() {
    }
   

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}


	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public double getAmount() {
		return amount;
	}





	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void addOrder(Product p, Bill b ,OrderLine O){
		O.setpAmount(b.getAmount());
		O.setpPrice(p.getPprice());
		O.setpQuantity(p.getPquantity());
		O.setpName(p.getPname());

		this.orderLine.add(O);
	}


	public ArrayList<OrderLine> getOrderLine() {
		return orderLine;
	}





	public void setOrderLine(ArrayList<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}


	
	public void viewBill(int id) {


    }

}