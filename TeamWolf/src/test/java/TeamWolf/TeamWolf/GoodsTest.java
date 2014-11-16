package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBL_driver;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class GoodsTest {

	static GoodsBL_driver gd;
	GoodsVO g1=new GoodsVO(null, null, "我是假货", null, null, null, null, null, null, null);
	GoodsVO g2=new GoodsVO(null, null, "飞利浦日光灯", null, null, null, null, null, null, null);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String IP="127.0.0.1";
		gd=new GoodsBL_driver(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAdd() {
		assertEquals(1112, gd.addGoods(g1));
		assertEquals(0, gd.addGoods(g2));
	}
	@Test
	public void testFin() {
		assertEquals(1112, gd.finGoods(g1));
		assertEquals(0, gd.finGoods(g2));
	}
	@Test
	public void testUpd() {
		assertEquals(1112, gd.updGoods(g1));
		assertEquals(0, gd.updGoods(g2));
	}
	@Test
	public void testSetWL() {
		
	}
	@Test
	public void testDel() {
		assertEquals(1112, gd.delGoods(g1));
		assertEquals(0, gd.delGoods(g2));
	}
	@Test
	public void testSho() {
		assertEquals(0, gd.shoGoods());
	}
	@Test
	public void testShoS() {
		assertEquals(0, gd.shoStock());
	}
	@Test
	public void testShoSD() {
		assertEquals(0, gd.shoStockD());
	}
	@Test
	public void testIncrease() {
		assertEquals(1112, gd.increaseToMatch(g1));
		assertEquals(0, gd.increaseToMatch(g2));
	}
	@Test
	public void testDecrease() {
		assertEquals(1112, gd.decreaseToMatch(g1));
		assertEquals(0, gd.decreaseToMatch(g2));
	}

}
