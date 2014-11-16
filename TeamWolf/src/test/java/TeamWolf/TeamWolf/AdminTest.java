package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.userBL.Admin_driver;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class AdminTest {
	static String IP;
	static Admin_driver ad;
	UserVO WHJ = new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
	UserVO WKS = new UserVO("WKS", "131250196", "sale_01", UserType.销售经理);
	UserVO XYJ = new UserVO("XYJ", "131250197", "stock_01", UserType.库存管理员);
	UserVO GYQ = new UserVO("GYQ", "131250135", "finance_01", UserType.财务人员);
	UserVO any = new UserVO("anyone", "******", "******", UserType.系统管理员);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP = "127.0.0.1";
		ad = new Admin_driver(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void addUser() {
		assertEquals(30001, ad.addUser(GYQ));
		assertEquals(30001, ad.addUser(WHJ));
		assertEquals(30001, ad.addUser(WKS));
		assertEquals(30001, ad.addUser(XYJ));
		assertEquals(0, ad.addUser(any));
		System.out.println("add anyone");
	}
	
	@Test
	public void removeUser(){
		assertEquals(30002, ad.removeUser("***"));
		System.out.println("remove fail");
		//System.out.println(ad.removeUser("anyone"));
		assertEquals(0, ad.removeUser("anyone"));
		System.out.println("remove anyone");
	}

}
