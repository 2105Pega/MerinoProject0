package com.revature.services;

import java.util.ArrayList;

import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.app.Driver;
import com.revature.users.Customer;
import com.revature.users.UserList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerService {
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	public static void service(Customer customer, UserList ul, Scanner sc) {

		while (true) {
			// Welcome
			System.out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName()
					+ ". We have your phone number and address listed as:");
			System.out.println("Phone number: " + customer.getPhone() + ".");
			System.out.println("Address:");
			System.out.println(customer.getAddress());

			// Select to update info, see accounts, or exit.

			System.out.println(
					"Please type 'update' if you would like to update your personal information, 'password' to update it, 'accounts' to see your bank accounts, 'open' to open a new account or 'exit' to leave the program.");

			String response = sc.nextLine();
			if (response.equals("exit")) {

				break;
			}
			switch (response) {
			case "update":
				CustomerService.update(customer, sc, ul);

				continue;

			case "accounts":
				CustomerService.accounts(customer, ul, sc);

				continue;
			case "password":
				CustomerService.updatePassword(customer, sc, ul);

				continue;
			case "open":
				CustomerService.openAccount(customer, ul, sc);
			default:
				System.out.println("Please select and type one of the options provided.");
				break;
			}

		}
		System.out.println("Good bye " + customer.getFirstName() + " " + customer.getLastName() + ".");

	}

	public static void listAccounts(Customer customer) {
		for (int i = 0; i < customer.getNumberOfAccounts(); i++) {
			int j = i + 1;
			System.out.println(j + ". " + customer.getAccount(i));
		}
	}

	public static void updatePassword(Customer customer, Scanner sc, UserList ul) {
		while (true) {
			System.out.println("Please type your new password.");
			String pass = sc.nextLine();
			System.out.println("Please type your new password again.");
			String conf = sc.nextLine();
			if (pass.equals(conf)) {
				customer.setPassword(pass);
				UserListService.writeUL(ul);
				logger.trace("Changed password for user " + customer.getUserName()  );
				
				break;
			} else {
				System.out.println("The passwords didn't match");
			}
		}
	}

	public static void update(Customer customer, Scanner sc, UserList ul) {
		System.out.println("Please provide your new phone number.");

		String newPhone = sc.nextLine();
		customer.setPhone(newPhone);
		UserListService.writeUL(ul);
		logger.trace("Updated phone number for user " + customer.getUserName() + ". New phone number is: " + customer.getPhone() + "." );
		System.out.println("Please provide your new address.");
		String newAddress = sc.nextLine();
		customer.setAddress(newAddress);
		UserListService.writeUL(ul);
		logger.trace("Updated address for user " + customer.getUserName() + ". New address is: " + customer.getAddress() + "." );
		System.out.println("Your information has been updated!");

	}

	public static void accounts(Customer customer, UserList ul, Scanner sc) {
		while (true) {
			System.out.println("These are your current bank accounts:");
			CustomerService.listAccounts(customer);
			System.out.println(
					"If you would like to make a deposit type 'deposit', 'withdraw' for a withdrawl, 'transfer' for a transfer and 'exit' to exit accounts screen.");
			String response = sc.nextLine();
			if (response.equals("deposit")) {
				System.out.println(
						"Type the number listed for the account in which you wish to deposit. For example type '1' for the first account listed.");
				response = sc.nextLine();
				int index;
				try {
					index = Integer.valueOf(response) - 1;
					if (index < 0) {
						System.out.println("Your number should be bigger than 0");

						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				System.out.println("Type the amount you wish to deposit.");

				String response2 = sc.nextLine();
				double amount;

				try {
					amount = Double.parseDouble(response2);
					amount = Math.round(amount * 100) / 100;
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				try {
					String deposit = tServices.deposit(amount, customer.getAccount(index));
					System.out.println(deposit);
					UserListService.writeUL(ul);
					logger.trace("Deposit attempt was made. Result: " + deposit);

					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You don't have enough accounts to match your choice of account.");

					continue;
				}

			} else if (response.equals("withdraw")) {
				System.out.println(
						"Type the number listed for the account from which you wish to withdraw. For example type '1' for the first account listed.");
				response = sc.nextLine();
				int index;
				try {
					index = Integer.valueOf(response) - 1;
					if (index < 0) {
						System.out.println("Your number should be bigger than 0");

						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				System.out.println("Type the amount you wish to withdraw.");

				String response2 = sc.nextLine();
				double amount;
				try {
					amount = Double.parseDouble(response2);
					amount = Math.round(amount * 100) / 100;
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				try {
					String withdraw = tServices.withdraw(amount, customer.getAccount(index));
					System.out.println(withdraw);
					UserListService.writeUL(ul);
					logger.trace("A withdrawl attempt was made. Result: " + withdraw);

					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You don't have enough accounts to match your choice of account.");

					continue;
				}
			} else if (response.equals("transfer")) {
				System.out.println(
						"Type the number listed for the account from which you wish to transfer. For example type '1' for the first account listed.");
				response = sc.nextLine();
				int index;
				try {
					index = Integer.valueOf(response) - 1;
					if (index < 0) {
						System.out.println("Your number should be bigger than 0");

						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				System.out.println("Type the amount you wish to transfer.");

				String response2 = sc.nextLine();
				double amount;
				try {
					amount = Double.parseDouble(response2);
					amount = Math.round(amount * 100) / 100;
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}

				System.out.println("Type the full account number you wish to transfer to.");
				String response3 = sc.nextLine();
				int accountReceiving;
				try {
					accountReceiving = Integer.valueOf(response3);

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				try {
					String result = tServices.transfer(amount, customer.getAccount(index),
							UserListService.findAccount(ul, accountReceiving));
					UserListService.writeUL(ul);
					logger.trace("A transfer attempt was made. Result: " + result);
					System.out.println(result);
					
					

					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You don't have enough accounts to match your choice of account.");

					continue;
				} catch (NullPointerException e) {
					System.out.println("Receiving account could not be found.");
				}
			} else if (response.equals("exit")) {

				break;
			} else {
				System.out.println("Please type a valid response.");

				continue;
			}

		}
	}

	public static void openAccount(Customer customer, UserList ul, Scanner sc) {
		while (true) {
			System.out.println(
					"Please write 'Checking' to open a checking account, write 'Savings' to open a savings account, or write 'exit' to exit this menu.");

			String type = sc.nextLine();
			if (type.equals("exit")) {

				break;
			} else if (!type.equals("Checking") && !type.equals("Savings")) {
				System.out.println("Invalid selection.");

				continue;
			} else {
				System.out.println("Please type your initial deposit amount.");
				String response2 = sc.nextLine();
				double amount;
				try {
					amount = Double.parseDouble(response2);
					amount = Math.round(amount * 100) / 100;
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");

					continue;
				}
				ArrayList<Customer> cuslist = new ArrayList<Customer>();
				cuslist.add(customer);
				while (true) {
					System.out.println(
							"Please type the user name of any joint account holders or type 'done' when no more users need to be added.");
					String answer = sc.nextLine();
					if (answer.equals("done")) {
						break;
					} else {
						Customer newCus = UserService.findCustomer(ul, answer);
						if (newCus == null) {
							System.out.println("No such user.");
						} else if (newCus == customer) {
							System.out.println("Can't add yourself as a joint account holder. You are already included in this request.");
						}
							else {
							cuslist.add(newCus);
						}

					}

				}

				Account a = new Account(ul, amount, type.toString(), cuslist.toArray(new Customer[cuslist.size()]));
				UserListService.writeUL(ul);
				StringBuilder sb = new StringBuilder();
				sb.append("A new account was created. Account number [");
				sb.append(a.getAccountNumber());
				sb.append("] has balance ");
				sb.append(a.getBalance());
				sb.append(", and is assigned to users:");
				for (Customer cus: a.getCustomerList()) {
					
					sb.append(" " + cus.getUserName() + ";");
				}
				
				String log = sb.toString();
				logger.trace(log);
				System.out.println("Account [" + a.getAccountNumber() + "] was created with initial balance "
						+ a.getBalance() + ". Account holders are:");
				for (int i = 0; i < cuslist.size(); i++) {
					int j = i + 1;
					System.out.println(
							j + ". " + cuslist.get(i).getFirstName() + " " + cuslist.get(i).getLastName() + ".");
				}
				break;
			}
		}

	}

}
