package com.revature.services;

import java.util.Scanner;

import com.revature.users.Customer;
import com.revature.users.UserList;

public class CustomerService {

	public static void service(Customer customer, UserList ul) {
		// Welcome
		System.out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName()
				+ ". We have your phone number and address listed as:");
		System.out.println("Phone number: " + customer.getPhone() + ".");
		System.out.println("Address:");
		System.out.println(customer.getAddress());

		// Select to update info, see accounts, or exit.
		while (true) {
			System.out.println(
					"Please type 'update' if you would like to update your personal information, 'password' to update it, 'accounts' to see your bank accounts or 'exit' to leave the program.");
			Scanner sc = new Scanner(System.in);
			String response = sc.nextLine();
			switch (response) {
			case "update":
				CustomerService.update(customer);
				break;
			case "accounts":
				CustomerService.accounts(customer, ul);
				break;
			case "password":
				CustomerService.updatePassword(customer);
				break;
			default:
				break;
			}
			if (response == "exit") {
				sc.close();
				break;
			} else {
				System.out.println("Please select and type one of the options provided.");
				sc.close();
			}
		}

	}

	public static void listAccounts(Customer customer) {
		for (int i = 0; i < customer.getNumberOfAccounts(); i++) {
			int j = i + 1;
			System.out.println(j + ". " + customer.getAccount(i));
		}
	}

	public static void updatePassword(Customer customer) {
		while (true) {
			System.out.println("Please type your new password.");
			Scanner sc = new Scanner(System.in);
			String pass = sc.nextLine();
			System.out.println("Please type your new password again.");
			String conf = sc.nextLine();
			if (pass == conf) {
				customer.setPassword(pass);
				sc.close();
				break;
			} else {
				System.out.println("The passwords didn't match");
				sc.close();
			}
		}
	}

	public static void update(Customer customer) {
		System.out.println("Please provide your new phone number.");
		Scanner sc = new Scanner(System.in);
		String newPhone = sc.nextLine();
		customer.setPhone(newPhone);
		System.out.println("Please provide your new address.");
		String newAddress = sc.nextLine();
		customer.setAddress(newAddress);
		System.out.println("Your information has been updated!");
		sc.close();
	}

	public static void accounts(Customer customer, UserList ul) {
		while (true) {
			System.out.println("These are your current bank accounts:");
			CustomerService.listAccounts(customer);
			System.out.println(
					"If you would like to make a deposit type 'deposit', 'withdraw' for a withdrawl, 'transfer' for a transfer and 'exit' to exit accounts screen.");
			Scanner sc = new Scanner(System.in);
			String response = sc.nextLine();
			if (response == "deposit") {
				System.out.println(
						"Type the number listed in which you wish to deposit. For example type '1' for the first account listed.");
				response = sc.nextLine();
				int index;
				try {
					index = Integer.valueOf(response) - 1;
					if (index < 0) {
						System.out.println("Your number should be bigger than 0");
						sc.close();
						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");
					sc.close();
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
					sc.close();
					continue;
				}
				try {
					System.out.println(tServices.deposit(amount, customer.getAccount(index)));
					sc.close();
					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You don't have enough accounts to match your choice of account.");
					sc.close();
					continue;
				}

			} else if (response == "withdraw") {
				System.out.println(
						"Type the number listed in which you wish to withdraw. For example type '1' for the first account listed.");
				response = sc.nextLine();
				int index;
				try {
					index = Integer.valueOf(response) - 1;
					if (index < 0) {
						System.out.println("Your number should be bigger than 0");
						sc.close();
						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");
					sc.close();
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
					sc.close();
					continue;
				}
				try {
					System.out.println(tServices.withdraw(amount, customer.getAccount(index)));
					sc.close();
					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You don't have enough accounts to match your choice of account.");
					sc.close();
					continue;
				}
			} else if (response == "transfer") {
				System.out.println(
						"Type the number listed in which you wish to transfer. For example type '1' for the first account listed.");
				response = sc.nextLine();
				int index;
				try {
					index = Integer.valueOf(response) - 1;
					if (index < 0) {
						System.out.println("Your number should be bigger than 0");
						sc.close();
						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");
					sc.close();
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
					sc.close();
					continue;
				}
				
				System.out.println("Type the full account number you wish to transfer to.");
				String response3 = sc.nextLine();
				int accountReceiving;
				try {
					accountReceiving = Integer.valueOf(response3);
					
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry.");
					sc.close();
					continue;
				}
				try {
					String result = tServices.transfer(amount, customer.getAccount(index), UserListService.findAccount(ul, accountReceiving));
					if (result == null) {
						System.out.println("Receiving account could not be found.");
					} else {
						System.out.println(result);
					}
					sc.close();
					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("You don't have enough accounts to match your choice of account.");
					sc.close();
					continue;
				}
			} else if (response == "exit") {
				sc.close();
				break;
			} else {
				System.out.println("Please type a valid response.");
				sc.close();
				continue;
			}

		}
	}
}
