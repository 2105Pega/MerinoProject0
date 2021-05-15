package bankingApp;
import org.junit.jupiter.api.*;
import com.revature.users.*;
import com.revature.accounts.*;
import com.revature.services.tServices;

public class testBankingApp {
	
	@Test
	public void testAddAccount() {
		Customer c = new Customer("user", "pass", "Luis", "Merino");
		Account a = new Account(19, "checking", c);
		Assertions.assertEquals(a, c.getAccount(0));
	}
	@Test
	public void testCustomerList() {
		Customer d = new Customer("user2", "pass", "Luis", "Merino");
		Customer f = new Customer("user3", "pass", "Luis", "Merino");
		Account b = new Account(27.00, "saving", d, f);
		
		
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
	public void testWithdrawPending() {
		Customer u = new Customer("user4", "pass", "Luis", "Merino");
		Account c = new Account(20.00, "checking",  u);
		System.out.println(tServices.withdraw(19, c));
		Assertions.assertEquals(20, c.getBalance());
		Assertions.assertEquals("Pending", c.getApproved());
	}
	
	@Test
	public void testWithdraw() {
		Customer u = new Customer("user4", "pass", "Luis", "Merino");
		Account c = new Account(20.00, "checking",  u);
		c.setApproved("Approved");
		System.out.println(tServices.withdraw(19, c));
		System.out.println(tServices.withdraw(2, c));
		System.out.println(tServices.withdraw(0, c));
		Assertions.assertEquals(1, c.getBalance());
		
	}
	@Test
	public void testDepositPending() {
		Customer u = new Customer("user4", "pass", "Luis", "Merino");
		Account c = new Account(20.00, "checking",  u);
		System.out.println(tServices.deposit(19, c));
		Assertions.assertEquals(20, c.getBalance());
		Assertions.assertEquals("Pending", c.getApproved());
	}
	
	@Test
	public void testdeposit() {
		Customer u = new Customer("user4", "pass", "Luis", "Merino");
		Account c = new Account(20.00, "checking",  u);
		c.setApproved("Approved");
		System.out.println(tServices.deposit(19, c));
		System.out.println(tServices.deposit(2, c));
		System.out.println(tServices.deposit(0, c));
		Assertions.assertEquals(41, c.getBalance());
		
	}
	@Test
	public void testTransferPending() {
		Customer c = new Customer("user4", "pass", "Luis", "Merino");
		Account a = new Account(20.00, "checking",  c);
		Account b = new Account(20.00, "saving",  c);
		System.out.println(tServices.transfer(10, a, b));
		Assertions.assertEquals(20, a.getBalance());
		Assertions.assertEquals(20, b.getBalance());
		
	}
	@Test
	public void testTransferCancelled() {
		Customer c = new Customer("user4", "pass", "Luis", "Merino");
		Account a = new Account(20.00, "checking",  c);
		Account b = new Account(20.00, "saving",  c);
		a.setApproved("Cancelled");
		System.out.println(tServices.transfer(10, a, b));
		Assertions.assertEquals(20, a.getBalance());
		Assertions.assertEquals(20, b.getBalance());
		
	}
	@Test
	public void testTransferSame() {
		Customer c = new Customer("user4", "pass", "Luis", "Merino");
		Account a = new Account(20.00, "checking",  c);
		Account b = new Account(20.00, "saving",  c);
		System.out.println(tServices.transfer(10, a, a));
		Assertions.assertEquals(20, a.getBalance());
		Assertions.assertEquals(20, b.getBalance());
		
	}
	@Test
	public void testTransfer() {
		Customer c = new Customer("user4", "pass", "Luis", "Merino");
		Account a = new Account(20.00, "checking",  c);
		Account b = new Account(20.00, "saving",  c);
		a.setApproved("Approved");
		b.setApproved("Approved");
		System.out.println(tServices.transfer(10, a, b));
		Assertions.assertEquals(10, a.getBalance());
		Assertions.assertEquals(30, b.getBalance());
		
	}
}
