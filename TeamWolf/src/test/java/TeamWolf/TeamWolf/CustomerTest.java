package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.customerBL.Customer_driver;
import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class CustomerTest {
	static String IP;
	static Customer_driver cd;
	CustomerVO GD = new CustomerVO("1", "1", "1", "GD", "1", "1", "1", "1", "1", "1", "1", "1");
	CustomerVO GD2 = new CustomerVO("1", "1", "1", "GAODAN", "1", "1", "1", "1", "1", "1", "1", "1");
	CustomerVO GD3 = new CustomerVO("1", "1", "1", "FTW", "1", "1", "1", "1", "1", "1", "1", "1");
	CustomerVO GD4 = new CustomerVO("1", "1", "1", "WAM", "1", "1", "1", "1", "1", "1", "1", "1");
	CustomerVO GOGOGO = new CustomerVO("1", "1", "1", "这个是错的哈哈哈", "1", "1", "1", "1", "1", "1", "1", "1");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP="127.0.0.1";
		cd = new Customer_driver(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void addCustomer(){
		assertEquals(12138, cd.addCustomer(GD));
		assertEquals(12138, cd.addCustomer(GD2));
		assertEquals(12138, cd.addCustomer(GD3));
		assertEquals(12138, cd.addCustomer(GD4));
		assertEquals(0, cd.addCustomer(GOGOGO));
		System.out.println("add");
	}
	
}
