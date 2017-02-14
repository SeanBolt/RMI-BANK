import java.beans.Statement;
import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Bank extends UnicastRemoteObject implements BankInterface {

private BigDecimal bankBalance = new BigDecimal(1000);
private Account acc1 = new Account("JohnDoe","123", bankBalance);
private Account acc2 = new Account("JohnAppleseed","123", bankBalance);
private List<Account> accounts = Arrays.asList(acc1, acc2); // users accounts
private Account accountLoggedIn;
private SessionManager sessionManager;

public Bank() throws RemoteException
{
	
}

@Override
public long login(String username, String password) throws RemoteException {
	if(!this.isSessionValid()) {
		List<Account> result = this.accounts.stream()
			     .filter(item -> item.getAccountName().equals(username))
			     .filter(item -> item.getPassword().equals(password))
			     .collect(Collectors.toList());
		
		if(result.size() == 1) {
			System.out.println("Account found .... Logging in ....");
			SessionManager sessionManager = new SessionManager(result.get(0));
			long sessionKey = sessionManager.restartTimer();
			this.sessionManager = sessionManager;
			this.accountLoggedIn = result.get(0);
			this.accountLoggedIn.setSessionKey(sessionKey);
			return sessionKey;
			
		} else if(result.size() == 0) {
			System.out.println("Account not found .... Please try again");
			
		} else if(result.size() > 1) {
			System.out.println("Multiple accounts found ... please contact customer service");
		}
		return 0;
	} else {
		System.out.println("There is an account already logged in");
		return 1;
	}
}

@Override
public void deposit(int amount) throws RemoteException {
	System.out.println("Account is " + this.accountLoggedIn.getAccountName());
	System.out.println("Session manager is " + this.sessionManager.getIsValid());
	
	if(this.isSessionValid()) {
		BigDecimal decimalAmount = new BigDecimal(amount);
		this.accountLoggedIn.deposit("Deposit", decimalAmount);
	}
}

@Override
public void withdraw(int amount) throws RemoteException {
	if(this.isSessionValid() == true) {
		BigDecimal decimalAmount = new BigDecimal(amount);
		this.accountLoggedIn.withdraw("Withdraw", decimalAmount);
	}	
}

@Override
public int inquiry(int accountnum) throws RemoteException {
	// TODO Auto-generated method stub
	System.out.println("Queried by ATM");
	if(this.isSessionValid() == true) {
		return this.accountLoggedIn.getAccountBalance().intValue();
	}
	return 0;
}

@Override
public Statement getStatement(Date from, Date to) throws RemoteException {
	if(this.isSessionValid() == true) {
		TransactionStatement statement = new TransactionStatement(accountLoggedIn, from, to);
		System.out.println(statement.statementSummary());
	}
	return null;
}

public Boolean isSessionValid() {
	if(this.sessionManager != null) {
		if(this.sessionManager.getIsValid()) {
			return true;
		} else {
			this.accountLoggedIn = null;
			System.out.println("You must log in again");
			return false;
		}
	} else {
		return false;
	}
}

public static void main(String args[]) {
	try {
		//Reset Security Manager
//		System.setSecurityManager(new SecurityManager());
//		System.out.println("Set Security Manager");
		
		//Create instance of local object
		Bank bank = new Bank();
		System.out.println("Created instance of Bank");
		
		//Add object to Registry
		Naming.rebind("//localhost:7777/server", bank);
		System.out.println("Name rebind complete");
		System.out.println("Server ready for requests");
		
	} catch(Exception e) {
		//Print error to console
		System.out.println("Error in main - " + e.toString());
	}
}

}
