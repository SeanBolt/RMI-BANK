import java.math.BigDecimal;
import java.util.Date;


public class Transaction {
	private String description;
	private BigDecimal amount;
	private Date date;
	
//	Constructors
	public Transaction(String description, BigDecimal amount){
		this.description = description;
		this.amount = amount;
		this.date = new Date();
	}
	
	public String toString() {
        return "Transaction: " + this.date.toString() 
        	+ "\t" + this.description
        	+ "\t" + this.amount;
    }
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
