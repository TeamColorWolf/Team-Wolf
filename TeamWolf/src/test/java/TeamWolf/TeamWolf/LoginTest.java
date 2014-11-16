package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.userBL.Login_driver;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class LoginTest {
	static String IP;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP = "127.0.0.1";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		LoginUserVO WHJ = new LoginUserVO("WHJ", "131250194");
		UserVO whj = new UserVO("WHJ", "131250194", "manage_01", UserType.总经理);
		Login_driver login = new Login_driver(IP, WHJ);
		assertEquals(whj.userName, login.getBack.userName);
		assertEquals(whj.password, login.getBack.password);
		assertEquals(whj.workID, login.getBack.workID);
		assertEquals(whj.power, login.getBack.power);
	}

}
