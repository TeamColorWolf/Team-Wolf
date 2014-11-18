package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import java.net.InetAddress;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.userBL.Login_driver;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;
import TeamWolf.TeamWolf.server.DATAfactory.DATAfactory;

public class LoginTest {
	static String IP;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		IP = addr.getHostAddress().toString();//获得本机IP
		
		new DATAfactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		LoginUserVO WHJ = new LoginUserVO("admin", "admin");
		UserVO whj = new UserVO("admin", "admin", "admin_01", UserType.系统管理员);
		Login_driver login = new Login_driver(IP, WHJ);
		assertEquals(whj.userName, login.getBack.userName);
		assertEquals(whj.password, login.getBack.password);
		assertEquals(whj.workID, login.getBack.workID);
		assertEquals(whj.power, login.getBack.power);
	}

}
