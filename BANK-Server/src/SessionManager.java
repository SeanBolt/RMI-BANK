import java.math.BigDecimal;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SessionManager {

	private Account account;
	private int sessionlength = 500000;
	private Boolean isValid = false;
	private long sessionKey;
	private Timer timer;
	
	public SessionManager(Account account) {
		this.account = account;
		Random random = new Random();
		this.sessionKey = (long)(random.nextDouble()*10000000);
	}
	
	
	public long restartTimer() {
		this.isValid = true;
		this.timer = new Timer();
		this.timer.schedule(new TimerTask(){

			@Override
			public void run() {
				isValid = false;
				System.out.println("Logged out due to expired session");
			}	
		}, this.sessionlength);
		
		return this.sessionKey;
	}
	
	
	public static void main(String [] args) {
		BigDecimal balance = new BigDecimal(100);
		Account ac = new Account("John Doe", "123", balance);
		SessionManager sm = new SessionManager(ac);
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public int getSessionlength() {
		return sessionlength;
	}


	public void setSessionlength(int sessionlength) {
		this.sessionlength = sessionlength;
	}


	public Boolean getIsValid() {
		return this.isValid;
	}


	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}


	public long getSessionKey() {
		return sessionKey;
	}


	public void setSessionKey(long sessionKey) {
		this.sessionKey = sessionKey;
	}


	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	//Getters & Setters
	
}
