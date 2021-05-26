package com.revature.services;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//import com.revature.accounts.Account;
//import com.revature.users.Customer;
//import com.revature.users.Employee;
//import com.revature.users.UserList;

public class UserListService {
	//Class made obsolete by incorporating database to program.
//	public static void writeUL(UserList ul) {
//		try {
//			FileOutputStream fos = new FileOutputStream("src/main/resources/UserData.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(ul);
//			oos.close();
//			fos.close();
//
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}
//
//	public static UserList readUL() {
//		try {
//			FileInputStream fis = new FileInputStream("src/main/resources/UserData.txt");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			UserList uList = (UserList) ois.readObject();
//			ois.close();
//			fis.close();
//			return uList;
//		} catch (IOException ioe) {
//			// ioe.printStackTrace();
//			return UserList.getInstance();
//		} catch (ClassNotFoundException c) {
//			return UserList.getInstance();
//		}
//
//	}
//
//	public static Account findAccount(UserList ul, int accountNumber) {
//
//		for (Customer cus : ul.getCusList()) {
//			for (int i = 0; i < cus.getNumberOfAccounts(); i++) {
//				if (cus.getAccount(i).getAccountNumber() == accountNumber) {
//					Account a = cus.getAccount(i);
//					return a;
//				}
//			}
//		}
//		return null;
//	}
//
//	public static Customer findCustomer(UserList ul, String user) {
//
//		for (Customer cus : ul.getCusList()) {
//			if (cus.getUserName().equals(user)) {
//				Customer c = cus;
//				return c;
//			}
//
//		}
//		return null;
//	}
//	public static Employee findEmployee(UserList ul, String user) {
//
//		for (Employee emp: ul.getEmpList()) {
//			if (emp.getUserName().equals(user)) {
//				Employee e = emp;
//				return e;
//			}
//
//		}
//		return null;
//	}
}
