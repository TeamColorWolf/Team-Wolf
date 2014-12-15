package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TeamWolf.TeamWolf.client.BL.financeBL.Account;
import TeamWolf.TeamWolf.client.vo.financeVO;
import TeamWolf.TeamWolf.ErrorTW;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	
	//正常增加账户
	@Test
	public void Order10_addAccountTest1(){
		financeVO GD = new financeVO("测试1");
		assertEquals(0, ad.add(GD));
	}
	
	//增加重复客户
	@Test
	public void Order11_addAccountTest2(){
		financeVO GD = new financeVO("测试1");
		assertEquals(ErrorTW.accountNameExist, ad.add(GD));
	}
	
	//信息不全
	/*@Test
	public void Order12_addAccountTest3(){
		financeVO GD = new financeVO("");
		assertEquals(ErrorTW.notComplete, ad.add(GD));
	}*/
	
	//正常删除账户
	@Test
	public void Order13_deldeteAccountTest1(){
		financeVO GD = new financeVO("测试1");
		assertEquals(0, ad.delete(GD));
	}
	
	//删除一个不存在的账户
	@Test
	public void Order14_deldeteAccountTest2(){
		financeVO GD = new financeVO("测试1");
		assertEquals(ErrorTW.notFound, ad.delete(GD));
	}
	
	//删除一个交易过的账户
	@Test
	public void Order15_deldeteAccountTest2(){
		financeVO GD1 = new financeVO("测试2",100);
		financeVO GD2 = new financeVO("测试2");
		ad.add(GD1);
		assertEquals(ErrorTW.notFound, ad.delete(GD2));
	}
	
	//正常修改账户
	@Test
	public void Order16_ModAccountTest1(){
		financeVO GD1 = new financeVO("测试3");
		financeVO GD2 = new financeVO("改了测试3");
		if(ad.find(GD1)==null){
		   ad.add(GD1);
		}
		if(ad.find(GD2)!=null){
		   ad.delete(GD2);
		}
		assertEquals(0,ad.update(GD1, GD2));
	}
	
	//修改一个不存在的账户
	@Test
	public void Order17_ModAccountTest2(){
		financeVO GD1 = new financeVO("测试4");
		financeVO GD2 = new financeVO("改了测试4");
		assertEquals(ErrorTW.accountNameNotExist,ad.update(GD1, GD2));
	}
	
	//修改后的账户名已存在
	@Test
	public void Order18_ModAccountTest3(){
		financeVO GD1 = new financeVO("测试5");
		financeVO GD2 = new financeVO("测试5");
		ad.add(GD1);
		assertEquals(ErrorTW.accountNameNotExist,ad.update(GD1, GD2));
	}
	
	//寻找账户
	@Test
	public void Order19_findAccountTest1(){
		financeVO GD1 = new financeVO("测试5");
		ad.add(GD1);
		int isFind = 0;
		if(!ad.find(GD1).getName().equals(GD1.getName())){
			isFind=ErrorTW.notFound;
		}
		assertEquals(0,isFind);
	}

	//寻找账户——账户不存在
		@Test
		public void Order20_findAccountTest2(){
			financeVO GD1 = new financeVO("测试100");
			int isFind = 0;
			if(ad.find(GD1)==null){
				isFind=ErrorTW.notFound;
			}
			assertEquals(ErrorTW.notFound,isFind);
		}

	
	
	
}
