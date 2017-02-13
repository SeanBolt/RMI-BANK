import java.rmi.*;

//The command line parameters of the ATM client application include:
//server_address: the address of the rmiregistry
//server_port: the port of the rmiregistry
//operation: one of "login", "deposit", "withdraw", and "inquiry"
//account: the user account
//username: only for "login" operation
//password: only for "login" operation
//amount: only for user deposit and user withdraw operations

public class ATM {

public static void main (String args[]) throws Exception {

// get user input, and perform the operations
    String name = "rmi://" + "127.0.0.1" +":"+1099+"/bank";
	BankInterface bank = (BankInterface) Naming.lookup(name);
	
	try {
		int funds = bank.inquiry(0, 0);
		System.out.println("Bank Enquirey has returned a value of " + funds);
	} catch(Exception e) {
		System.out.println("Error in main - " + e.toString());
	}
}

}