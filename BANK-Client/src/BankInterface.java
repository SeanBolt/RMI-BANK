import java.beans.Statement;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BankInterface extends Remote {

public long login(String username, String password) throws RemoteException;

public void deposit(int amount) throws RemoteException;

public void withdraw(int amount) throws RemoteException;

public int inquiry(int accountnum) throws RemoteException;

public Statement getStatement(Date from, Date to) throws RemoteException;

}