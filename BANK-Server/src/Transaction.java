import java.math.BigDecimal;
import java.util.Date;


public class Transaction {
	private String description;
	private Account account;
	private BigDecimal amount;
	private Date date;
	
	public Transaction(Account account, String description){
		this.account = account;
		this.description = description;
		this.date = new Date();
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Calendar transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public void withdraw(Account account, String description, Date date){
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds
		setTransactionTime(today);
	}
	
	public void deposit(Account account, String description, Date date){
		
	}

}
