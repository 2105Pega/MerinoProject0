package com.revature.app;
import com.revature.accounts.*;
import com.revature.users.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to Luis' banking app. To login type 'l', To create an account type'c', and to exit type 'e'." );
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		System.out.println(choice);
		sc.close();
	}
	
	
	
	
}