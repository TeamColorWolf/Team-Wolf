package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.stockBL.StockBLController;
import TeamWolf.TeamWolf.client.vo.TypeListVO;
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
		assertEquals(1002, result);          //商品分类已存在于系统中
		t1=new TypeVO("0003", "私密用品", "0005", "你猜猜");
		result=sbcontroller.addType(t1);
		assertEquals(1001, result);          //不可在有商品的分类下添加子分类		
		//t1=new TypeVO("0001", "实物商品", "0004", "正常的商品");
		//result=sbcontroller.addType(t1);
		//assertEquals(0, result);             //添加成功
		
	}
	
	@Test
	public void testDel() {
		int result=0;
		
		TypeVO t2=new TypeVO(null, null, "0006", "不存在啊");
		result=sbcontroller.delType(t2);
		assertEquals(1004, result);          //分类不存在于系统中
		t2=new TypeVO("0001", "实物商品", "0003", "私密用品");
		result=sbcontroller.delType(t2);
		assertEquals(1003, result);          //分类底下有子分类
		
	}
	
	@Test
	public void testUpd() {
		int result=0;
		
		TypeVO t3=new TypeVO(null, null, "0007", "不存在啊");
		result=sbcontroller.updType(t3);
		//System.out.println(result);
		assertEquals(1004, result);         //分类不存在
		t3=new TypeVO("0001", "实物商品", "0003", null);
		result=sbcontroller.updType(t3);
		assertEquals(1005, result);         //信息填写不完整
	}
	
	@Test
	public void testSho() {
		boolean finded=false;
	
		TypeListVO tl1=sbcontroller.shoAllType();
		if(tl1.typeL!=null)
			finded=true;
		assertTrue(finded);
	}
	
}
