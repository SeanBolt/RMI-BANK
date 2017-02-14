import java.rmi.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
            					   System.out.println("Successful login for "+args[3]+" session is valid for 6 minutes");
            				   }	   
                               break;
                               
            case "inquiry":    System.out.println("The current balance of your account is €" + bank.inquiry(0));
                               break;
                               
            case "deposit":    bank.deposit(Integer.parseInt(args[3]));
            				   System.out.println("Successfully deposited €" + args[3] + " to your account");
                               break;
                               
            case "withdraw":   bank.withdraw(Integer.parseInt(args[3]));
            				   System.out.println("Successfully withdrew €" + args[3] + " from your account");
            				   break;
            				   
            case "statement":  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            				   LocalDate start = LocalDate.parse(args[3], formatter);
            				   LocalDate end = LocalDate.parse(args[4], formatter);
            				   
            				   System.out.println(bank.getStatement(Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
            						   Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant())
    						   ));
            				   break;

            default: System.out.println("You need to provide a valid ATM action.");
                     break;
        }                     
	} catch(Exception e) {
		System.out.println("Error in main - " + e.toString());
		e.printStackTrace();
	}
}
}