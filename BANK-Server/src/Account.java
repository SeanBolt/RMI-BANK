import java.math.BigDecimal;

public class Account {
	private String accountName;
	private BigDecimal accountBalance;
	private int accountNumber = ++lastAssignedNumber;
	private static int lastAssignedNumber;
	
	public Account(String accountName, BigDecimal accountBalance) {
		this.accountName = accountName;
		this.accountBalance = accountBalance;
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
	
}
