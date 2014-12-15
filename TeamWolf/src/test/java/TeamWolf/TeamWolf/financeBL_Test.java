package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.financeBL.Account;
import TeamWolf.TeamWolf.client.vo.financeVO;
import TeamWolf.TeamWolf.ErrorTW;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class financeBL_Test {
 
	static String IP;
	static Account ad;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP="127.0.0.1";
		ad = new Account(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void addAccountTest1(){
		financeVO GD = new financeVO("测试1");
		assertEquals(0, ad.add(GD));
	}
	
	/*@Test
	public void addAccountTest2(){
		financeVO GD = new financeVO("测试1");
		assertEquals(ErrorTW.accountNameExist, ad.add(GD));
	}*/
	
	/*@Test
	public void addAccountTest3(){
		financeVO GD = new financeVO("");
		assertEquals(ErrorTW.notComplete, ad.add(GD));
	}*/
	
	/*@Test
	public void addAccountTest4(){
		financeVO GD = new financeVO("");
		assertEquals(ErrorTW.notComplete, ad.add(GD));
	}*/
	
	@Test
	public void deldeteAccountTest1(){
		financeVO GD = new financeVO("测试1");
		assertEquals(0, ad.delete(GD));
	}
	
	@Test
	public void deldeteAccountTest2(){
		financeVO GD = new financeVO("测试1");
		assertEquals(ErrorTW.notFound, ad.delete(GD));
	}
}
