package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TeamWolf.TeamWolf.client.BL.userBL.LoginController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.LoginBLservice;
import TeamWolf.TeamWolf.client.vo.LoginUserVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

@FixMethodOrder(MethodSorters.JVM)
public class LoginTest {
	static String IP;
	static LoginBLservice lbs;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		IP = addr.getHostAddress().toString();//获得本机IP
		lbs = new LoginController(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test_001_loginSuccess() {
		LoginUserVO login = new LoginUserVO("admin", "admin");
		UserVO user = lbs.login(login);
		assertEquals(user.error, 0);
		assertEquals(user.userName, "admin");
		assertEquals(user.password, "admin");
		assertEquals(user.power, UserType.系统管理员);
		assertEquals(user.workID, "admin_1");
	}
	
	@Test
	public void test_002_loginFail(){
		LoginUserVO login = new LoginUserVO("admin", "*****");
		UserVO user = lbs.login(login);
		assertEquals(user.error, 1);
	}
	
	@Test
	public void test_003_connectRefused(){
		lbs = new LoginController("128.0.0.1");
		LoginUserVO login = new LoginUserVO("admin", "admin");
		UserVO user = lbs.login(login);
		assertEquals(user, null);
	}

}
