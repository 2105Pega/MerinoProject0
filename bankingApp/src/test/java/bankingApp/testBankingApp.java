package bankingApp;
import org.junit.jupiter.api.*;
import com.revature.users.*;
import com.revature.accounts.*;
import com.revature.services.tServices;

public class testBankingApp {
	
	@Test
	public void testAddAccount() {
		Customer c = new Customer("user", "pass", "Luis", "Merino");
		Account a = new Account(19, c);
		Assertions.assertEquals(a, c.getAccount(0));
	}
	@Test
	public void testCustomerList() {
		Customer d = new Customer("user2", "pass", "Luis", "Merino");
		Customer f = new Customer("user3", "pass", "Luis", "Merino");
		Account b = new Account(27.00, d, f);
		
		
		Assertions.assertEquals(d, b.getCustomer(0));
		Assertions.assertEquals(f, b.getCustomer(1));
	}
	@Test
	public void testUserList() {
		UserList myList = UserList.getInstance();
		UserList myOtherList = UserList.getInstance();
		Assertions.assertEquals(myList, myOtherList);
		Assertions.assertEquals(myList.getUserList(), myOtherList.getUserList());
	}
	@Test
	public void testWithdraw() {
		Customer u = new Customer("user4", "pass", "Luis", "Merino");
		Account c = new Account(20.00, u);
		
		System.out.println(tServices.withdraw(19, c));
		System.out.println(tServices.withdraw(2, c));
		System.out.println(tServices.withdraw(0, c));
		
		
	}
	
}
