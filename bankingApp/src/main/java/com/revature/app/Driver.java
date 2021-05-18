package com.revature.app;
import com.revature.services.LoginService;
import com.revature.services.UserListService;
import com.revature.users.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserList ul = UserListService.readUL();
		
		
		
		
			try {
				LoginService.service(ul, sc);
			} catch (NoSuchElementException e) {
				UserListService.writeUL(ul);
				System.out.println("Force exiting the application.");
				logger.fatal("User exited the app forcefully using a shortcut.");
			} catch (RuntimeException e) {
				UserListService.writeUL(ul);
				System.out.println("Caught unexpected exeption. Closing the application after saving data.");
				logger.fatal("Unexpected RuntimeException");
			}
			
		
		
		UserListService.writeUL(ul);
		sc.close();
		logger.trace("Exited the application correctly after writting the state of our UserList.");
		
		
	}
	
	
	
	
}
