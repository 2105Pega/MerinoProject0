package com.revature.app;
import com.revature.services.LoginService;
import com.revature.services.UserListService;
import com.revature.users.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserList ul = UserListService.readUL();
		
		
		
		while (true) {
			try {
				LoginService.service(ul, sc);
			} catch (NoSuchElementException e) {
				UserListService.writeUL(ul);
				System.out.println("Force exiting the app.");
				
			}
			break;
		
		}
		UserListService.writeUL(ul);
		
		
		
		
	}
	
	
	
	
}
