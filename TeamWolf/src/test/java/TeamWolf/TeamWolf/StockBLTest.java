package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.stockBL.StockBLController;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBLTest {

	static StockBLController sbcontroller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		String IP="127.0.0.1";
		sbcontroller=new StockBLController(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAdd() {
		int result=0;
		
		TypeVO t1=new TypeVO(null, null, "0000", "特价包");
		result=sbcontroller.addType(t1);
		assertEquals(1002, result);          //商品已存在于系统中
		t1=new TypeVO("0003", "私密用品", "0005", "你猜猜");
		result=sbcontroller.addType(t1);
		assertEquals(1001, result);          //不可在有商品的分类下添加子分类
		t1=new TypeVO("0001", "实物商品", "0004", "正常的商品");
		result=sbcontroller.addType(t1);
		assertEquals(0, result);            //添加成功
		
	}
	
	@Test
	public void testDel() {
		int result=0;
		
		TypeVO t2=new TypeVO(null, null, "0006", "不存在啊");
		result=sbcontroller.delType(t2);
		assertEquals(1004, result);
	}
	
	@Test
	public void testUpd() {
		
	}
	
	@Test
	public void testSho() {
		
	}
	
}
