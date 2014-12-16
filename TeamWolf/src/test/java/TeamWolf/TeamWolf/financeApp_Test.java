package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceApplicationController;
import TeamWolf.TeamWolf.client.BL.financeBL.Account;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
import TeamWolf.TeamWolf.ErrorTW;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class financeApp_Test {
 
	static String IP;
	static FinanceApplicationController ad;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP="127.0.0.1";
		ad = new FinanceApplicationController(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//正常测试付款单 
	@Test
	public void Order10_addRecieptTest1(){
		ArrayList<financeVO> AccountArray = new ArrayList<financeVO>();
		ArrayList<String> moneyList = new ArrayList<String>();
		financeVO vo = new financeVO("测试5");
		String money = "11";
		AccountArray.add(vo);
	    moneyList.add(money);
		String number = "SKD-2014/12/16-99999";
		String operator = "试验一下，其实这里是自动加入的";
		String note = "测试一下，其实界面的输入机制保证了某些问题不会发生";
		CustomerVO GD = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		RecieptApplicationVO RAvo = new RecieptApplicationVO(AccountArray,moneyList,number,operator,note,GD);
		assertEquals(0, ad.submitRecieptApplication(RAvo));
	}
	
	//正常测试收款单
	@Test
	public void Order11_addPaymentTest1(){
		ArrayList<financeVO> AccountArray = new ArrayList<financeVO>();
		ArrayList<String> moneyList = new ArrayList<String>();
		financeVO vo = new financeVO("测试5");
		String money = "11";
		AccountArray.add(vo);
	    moneyList.add(money);
		String number = "FKD-2014/12/16-99999";
		String operator = "试验一下，其实这里是自动加入的";
		String note = "测试一下，其实界面的输入机制保证了某些问题不会发生";
		CustomerVO GD = new CustomerVO("1", "Test", "Test","TKSD", "1888", "NJU", "1888", 
				"574057633@qq.com", "10000", "10000", "10000", "WO");
		RecieptApplicationVO RAvo = new RecieptApplicationVO(AccountArray,moneyList,number,operator,note,GD);
		assertEquals(0, ad.submitRecieptApplication(RAvo));
	}
	

	
	
}
