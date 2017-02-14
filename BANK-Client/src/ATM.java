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
//	String name = "rmi://" + "127.0.0.1" +":"+1099+"/server";

	try {
		String hostAddress = args[0];
        String portNumber = args[1];
        BankInterface bank = (BankInterface) Naming.lookup("//"+ hostAddress +":"+ portNumber +"/server");
        
		String action = args[2];
        switch (action) {
            case "login":      bank.login(args[3], args[4]);
                               break;
            case "inquiry":    System.out.println("Bank Enquirey has returned a value of " + bank.inquiry(0, 0));
                               break;
            case "deposit":    Long id = new Long("1.23");
            				   bank.deposit(Integer.parseInt(args[3]), Integer.parseInt(args[4]), id );
                               break;
//            case "withdraw":   bank.withdraw(args[3], args[4]);
//                               break;
//            case "statement":  DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // 01/10/2016
//                               Date startDate = df.parse(args[4]);
//                               Date endDate = df.parse(args[5]);
//                               Statement statement = bank.getStatement(args[3], startDate, endDate);
//                               printStatement(statement);
//                               break;
            default: System.out.println("You need to provide a valid ATM action.");
                     break;
        }                     
	} catch(Exception e) {
		System.out.println("Error in main - " + e.toString());
	}
}
}