package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.financeBL.Account;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
import TeamWolf.TeamWolf.ErrorTW;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerBL_Test {
 
	static String IP;
	static CustomerOpr co;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP="127.0.0.1";
		co = new CustomerOpr(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//正常增加账户
	@Test
	public void Order10_addTest1(){
		CustomerVO GD = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		if(co.findCustomer("TKSD") == null){
			co.Customeradd(GD);
			assertEquals(0, co.Customeradd(GD));
		}
	}
	
	//增加重复客户
	@Test
	public void Order11_addTest2(){
		CustomerVO GD = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		assertEquals(ErrorTW.haveAlreadyExist, co.Customeradd(GD));
	}
	
	//信息不全
	/*@Test
	public void Order12_addTest3(){
		CustomerVO GD = new CustomerVO("", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		assertEquals(ErrorTW.notComplete, co.Customeradd(GD));
	}*/
	
	//正常删除客户
	
	@Test
	public void Order13_deldeteTest1(){
		CustomerVO GD = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		assertEquals(0, co.Customerdel(GD));
	}
	
	//删除一个不存在的账户
	@Test
	public void Order14_deldeteTest2(){
		CustomerVO GD = new CustomerVO("根本就没有", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		assertEquals(ErrorTW.notFondCustomer, co.Customerdel(GD));
	}
	
	//正常修改账户
	@Test
	public void Order16_ModTest1(){
		CustomerVO GD1 = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		CustomerVO GD2 = new CustomerVO("1", "Test", "Test","TKSD", "188899", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		if(co.findCustomer("1")==null){
		   co.Customeradd(GD1);
		  // System.out.println("s");
		}
		//if(co.findCustomer("1")!=null){
		 //  co.Customerdel(GD2);
		//}
		assertEquals(0,co.Customerupdate(GD1, GD2));
	}
	
	//修改一个不存在的账户
	@Test
	public void Order17_ModTest2(){
		CustomerVO GD1 = new CustomerVO("根本没有", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		CustomerVO GD2 = new CustomerVO("根本没有", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		assertEquals(ErrorTW.cannotOperateForNotExist,co.Customerupdate(GD1, GD2));
	}
	

	/*//修改后的编号已存在
	@Test
	public void Order18_ModTest3(){
		CustomerVO GD1 = new CustomerVO("修改专用", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		CustomerVO GD2 = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		co.Customeradd(GD1);
		assertEquals(ErrorTW.cannotOperateForNotExist,co.Customerupdate(GD1, GD2));
	}*/

	//寻找账户
	@Test
	public void Order19_findTest1(){
		CustomerVO GD1 = new CustomerVO("修改专用", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		int isFind = 0;
		co.Customeradd(GD1);
		if(!co.findCustomer("修改专用").getNum().equals(GD1.getNum())){
			isFind=ErrorTW.notFound;
		}
		assertEquals(0,isFind);
	}

	//寻找账户——账户不存在
		@Test
		public void Order20_findTest2(){
			CustomerVO GD1 = new CustomerVO("找不到我", "Test", "Test","TKSD", "1888", "NJU", "1888", 
					"574057633@qq.com", "10000", "10000", "10000", "WO");
			int isFind = 0;
			if(co.findCustomer("找不到我")==null){
				isFind=ErrorTW.notFound;
			}
			assertEquals(ErrorTW.notFound,isFind);
		}

	
	
	
}

