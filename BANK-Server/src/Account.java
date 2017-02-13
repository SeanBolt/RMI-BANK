import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Account {
	private String accountName;
	private BigDecimal accountBalance;
	private List<Transaction> transactions;
	private int accountNumber = ++lastAssignedNumber;
	private static int lastAssignedNumber;
	
	public Account(String accountName, BigDecimal accountBalance) {
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}

	public void withdraw(String description, BigDecimal amount){
		//Reduce Balance
		if(this.accountBalance.compareTo(amount) != -1){
			this.accountBalance.subtract(amount);
		}
		
		Transaction transaction = new Transaction(description, amount.negate());
		this.transactions.add(transaction);
	}
	
	public void deposit(String description, BigDecimal amount){
		//Increase Balance
		this.accountBalance.add(amount);
		
		Transaction transaction = new Transaction(description, amount);
		this.transactions.add(transaction);	
	}
	
	//	Getters & Setters
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}	
	
}
