package bankingApp;
import org.junit.jupiter.api.*;
import com.revature.users.*;
import com.revature.accounts.*;

public class testBankingApp {
	
	@Test
	public void testAddAccount() {
		Customer c = new Customer("user", "pass", "Luis", "Merino");
		Account a = new Account(20.00, c);
		
		c.addAccount(a);
		Assertions.assertEquals(a, c.getAccount(0));
	}
	@Test
	public void testCustomerList() {
		Customer c = new Customer("user", "pass", "Luis", "Merino");
		Customer d = new Customer("user2", "pass", "Luis", "Merino");
		Account a = new Account(20.00, c, d);
		Assertions.assertEquals(c, a.getCustomer(0));
		Assertions.assertEquals(d, a.getCustomer(1));
	}
	
	
}
