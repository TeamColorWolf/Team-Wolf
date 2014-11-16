package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import TeamWolf.TeamWolf.client.BL.financeBL.Account_driver;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class financeTest {
 
	static String IP;
	static Account_driver ad;
	
	financeVO GD = new financeVO("GD");
	financeVO JD = new financeVO("假的啊");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP="127.0.0.1";
		ad = new Account_driver(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void addCustomer(){
		assertEquals(49123, ad.add(GD));
		assertEquals(0, ad.add(JD));
		System.out.println("add");
	}
}
