import java.rmi.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
	
	try {
		String hostAddress = args[0];
        String portNumber = args[1];
        BankInterface bank = (BankInterface) Naming.lookup("//"+ hostAddress +":"+ portNumber +"/server");
        
		String action = args[2];
        switch (action) {
            case "login":      long sessionKey = bank.login(args[3], args[4]);
            
            				   if(sessionKey == (long) 0) {
            					   System.out.println("Login Unsuccessful. Account Details Not found");
            				   } else if(sessionKey == (long) 1) {
            					   System.out.println("Login Unsuccessful. There is an account logged in already");
            				   } else {
            					   System.out.println("Login Successful. Session Key is " + sessionKey);
            				   }
            				   
                               break;
                               
            case "inquiry":    System.out.println("Bank Enquirey has returned a value of " + bank.inquiry(0));
                               break;
                               
            case "deposit":    bank.deposit(Integer.parseInt(args[3]));
                               break;
                               
            case "withdraw":   bank.withdraw(Integer.parseInt(args[3]));
            				   break;
            				   
            case "statement":  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            				   LocalDate start = LocalDate.parse(args[3], formatter);
            				   LocalDate end = LocalDate.parse(args[4], formatter);
            				   
            				   bank.getStatement(Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
            						   Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant())
    						   );

            default: System.out.println("You need to provide a valid ATM action.");
                     break;
        }                     
	} catch(Exception e) {
		System.out.println("Error in main - " + e.toString());
		e.printStackTrace();
	}
}
}