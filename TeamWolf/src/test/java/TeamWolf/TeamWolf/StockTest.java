package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.stockBL.StockBL_driver;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockTest {

	static StockBL_driver sbd;
	
	TypeVO t1=new TypeVO(null, null, null, "照明灯类");
	TypeVO t2=new TypeVO(null, null, null, "不明觉厉类");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String IP="127.0.0.1";
		sbd=new StockBL_driver(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@Test
	public void testAdd() {
		assertEquals(1111, sbd.addType(t2));
		assertEquals(0, sbd.addType(t1));
	}
	
	@Test
	public void testUpd(){
		assertEquals(1111, sbd.updType(t2));
		assertEquals(0, sbd.updType(t1));
	}
	
	@Test
	public void testDel(){
		assertEquals(1111, sbd.delType(t2));
		assertEquals(0, sbd.delType(t1));
	}

	@Test
	public void testSho(){
		assertEquals(0, sbd.shoAllType());
	}
}
