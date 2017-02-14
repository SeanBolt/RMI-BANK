import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

public class SessionManager {

	private Account account;
	private int sessionlength = 60000;
	private static Boolean isValid;
	private Timer timer;
	
	public SessionManager(Account account) {
		this.account = account;
		this.isValid = true;
		this.restartTimer(this.sessionlength);
	}
	
	
	public void restartTimer(int sessionlength) {
		this.isValid = true;
		this.timer = new Timer();
		this.timer.schedule(new TimerTask(){

			@Override
			public void run() {
				SessionManager.isValid = false;		
			}	
		}, sessionlength);
	}
	
	
	public static void main(String [] args) {
		BigDecimal balance = new BigDecimal(100);
		Account ac = new Account("John Doe", "123", balance);
		SessionManager sm = new SessionManager(ac);
	}
}
