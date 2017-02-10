import java.beans.Statement;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

public class Bank extends UnicastRemoteObject implements BankInterface {

private List<Account> accounts; // users accounts

public Bank() throws RemoteException
{

}

@Override
public long login(String username, String password) throws RemoteException {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void deposit(int accountnum, int amount, long sessionID) throws RemoteException {
	// TODO Auto-generated method stub
	
}
@Override
public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException {
	// TODO Auto-generated method stub
	
}
@Override
public int inquiry(int accountnum, long sessionID) throws RemoteException {
	// TODO Auto-generated method stub
	return 888;
}
@Override
public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

public static void main(String args[]) {
	try {
		//Reset Security Manager
		System.setSecurityManager(new SecurityManager());
		System.out.println("Set Security Manager");
		
		//Create instance of local object
		Bank bank = new Bank();
		System.out.println("Created instance of Bank");
		
		//Add object to Registry
		Naming.rebind("Bank", bank);
		System.out.println("Name rebind complete");
		System.out.println("Server ready for requests");
		
	} catch(Exception e) {
		//Print error to console
		System.out.println("Error in main - " + e.toString());
	}
}

}
