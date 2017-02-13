import java.rmi.*;

//The command line parameters of the ATM client application include:
//server_address: the address of the rmiregistry
//server_port: the port of the rmiregistry
//operation: one of "login", "deposit", "withdraw", and "inquiry"
//account: the user account
//username: only for "login" operation
//password: only for "login" operation
//amount: only for “deposit” and “withdraw” operations

public class ATM {

public static void main (String args[]) throws Exception {

// get user’s input, and perform the operations
	BankInterface bank = (BankInterface) Naming.lookup("//localhost/bank");
	try {
	    switch (args[0]) {
	        case "inquiry":    
	        	bank.inquiry(0, 0);
	        	break;
	        default: System.out.println("You need to provide a valid ATM action.");
             	break;
	    }
    } catch(Exception e) {
		System.out.println("Error in main - " + e.toString());
	}
}

}