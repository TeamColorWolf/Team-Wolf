package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TeamWolf.TeamWolf.client.BL.userBL.AdminController;
import TeamWolf.TeamWolf.client.BLservice.userBLservice.AdminBLservice;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

@FixMethodOrder(MethodSorters.JVM)
public class AdminTest {
	static String IP;
	static AdminBLservice admin;
	UserVO WHJ = new UserVO("WHJ", "131250194", "manage_1", UserType.总经理);
	UserVO any = new UserVO("anyone", "******", "admin_2", UserType.系统管理员);
	UserVO cha = new UserVO("changeOne", "***", "admin_3", UserType.系统管理员);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP = "127.0.0.1";
		admin = new AdminController(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void test_001_addUserNotExist(){
		any.error = 0;
		int success = admin.addUser(any);
		assertEquals(success, 0);
		cha.error = 0;
		success = admin.addUser(cha);
		assertEquals(success, 0);
	}
	
	@Test
	public void test_002_addUserExist(){
		int fail = admin.addUser(WHJ);
		assertEquals(fail, ErrorTW.userNameExist);
	}
	
	@Test
	public void test_003_delUserExist(){
		int success = admin.removeUser(any.userName);
		assertEquals(success, 0);
	}
	
	@Test
	public void test_004_delUserNotExist(){
		int fail = admin.removeUser("***");
		assertEquals(fail, ErrorTW.userNameNotExist);
	}
	
	@Test
	public void test_005_updUserExist(){
		cha.password = "aaaaa";
		int success = admin.update(cha);
		assertEquals(success, 0);
		success = admin.removeUser(cha.userName);
		assertEquals(success, 0);
	}
	
	@Test
	public void test_006_updUserNotExist(){
		int fail = admin.update(cha);
		assertEquals(fail, ErrorTW.userNameNotExist);
	}

}
