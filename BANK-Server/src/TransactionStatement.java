import java.util.Date;
import java.util.List;

public class TransactionStatement implements Statement {

	private Account account;
	private Date startDate;
	private Date endDate;
	private List<Transaction> transactions;
		
	
	public TransactionStatement(Account account, Date startDate, Date endDate) {
		this.account = account;
		this.startDate = startDate;
		this.endDate = endDate;
		this.transactions = this.account.getTransactions();
	}
	
	public String statementSummary() {
		String printout = "Statement printout: \n"
				+"Start Date : " + this.startDate.toString() + "\n"
				+"End Date : " + this.endDate.toString() + "\n\n";
		for(Transaction transaction : transactions) {
			printout += transaction.toString() + "\n";
		}
		System.out.println(printout);
		return printout;
	}

	@Override
	public int getAccountnum() {
		return this.account.getAccountNumber();
	}

	@Override
	public Date getStartDate() {
		return this.startDate;
	}

	@Override
	public Date getEndDate() {
		return this.endDate;
	}

	@Override
	public String getAccoutName() {
		return this.account.getAccountName();
	}

	@Override
	public List getTransations() {
		return this.transactions;
	}

}
