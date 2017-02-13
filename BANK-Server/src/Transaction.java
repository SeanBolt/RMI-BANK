import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private String accountName;
	private String dscrptn;
	private Account acnt;
	private BigDecimal amnt;
	private Date startDate;
	private Date endDate;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getDscrptn() {
		return dscrptn;
	}
	public void setDscrptn(String dscrptn) {
		this.dscrptn = dscrptn;
	}
	public BigDecimal getAmnt() {
		return amnt;
	}
	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Account getAcnt() {
		return acnt;
	}
	public void setAcnt(Account acnt) {
		this.acnt = acnt;
	}
	

}
