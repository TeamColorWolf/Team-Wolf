package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.vo.GoodsAlarmVO;
import TeamWolf.TeamWolf.client.vo.GoodsListVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class GoodsBLTest {

	static GoodsBLController gbcontroller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		String IP="127.0.0.1";
		gbcontroller=new GoodsBLController(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	    
	@Test
	public void testAdd() {
		int result=0;
		
		GoodsVO g1=new GoodsVO("0001", "实物商品", "00010001", "不正确哦", "错误", "0", "66", "77", null, null, null);
		result=gbcontroller.addGoods(g1);
		assertEquals(2001, result);      //分类下有子分类
		g1=new GoodsVO("0003", "私密用品", "00030001", "CQWW", "CQ01", "0", "56", "999", null, null, null);
		result=gbcontroller.addGoods(g1);
		assertEquals(2002, result);      //商品已存在
	}
    
	@Test
	public void testDel() {
		int result=0;
		
		GoodsVO g2=new GoodsVO("0001", "实物商品", "00030001", "CQWW", "CQ01", "0", null, null, null, null, null);
		result=gbcontroller.delGoods(g2);
		assertEquals(2003, result);      //商品与所填父分类不匹配
		g2=new GoodsVO("0002", "虚拟商品", "00020003", "不存在", null, null, null, null, null, null, null);
		result=gbcontroller.delGoods(g2);
		assertEquals(2004, result);      //商品不存在
	}
	
	@Test
	public void testUpd() {
		int result=0;
		
		GoodsVO g3=new GoodsVO("0002", "虚拟商品", "00020003", "不存在", null, null, "77", "66", null, null, null);
		result=gbcontroller.updGoods(g3);
		assertEquals(2004, result);
	}
	
	@Test
	public void testFin() {
		
		GoodsVO g4=new GoodsVO("0002", "虚拟商品", "00020003", "不存在", null, null, "77", "66", null, null, null);
		GoodsVO fin=gbcontroller.finGoods(g4);
		assertEquals(null, fin);
		
		g4=new GoodsVO("0003", "私密用品", "00030001", "CQWW", "CQ01", null, null, null, null, null, null);
		fin=gbcontroller.finGoods(g4);
		assertEquals("00030001", fin.getNumber());
	}
	
	@Test
	public void testSho() {
		
		GoodsListVO gl=gbcontroller.shoGoods();
		boolean finded=false;
		if(gl.gList!=null)
			finded=true;
		assertTrue(finded);
	}
	
	@Test
	public void testDimFin() {
		
		boolean right=true;
		GoodsVO toDimFin=new GoodsVO(null, null, null, "CQWW", "TK01", null, null, null, null, null, null);
		ArrayList<GoodsVO> result=gbcontroller.dimFinGoods(toDimFin);
		for(GoodsVO g: result){
			if((!g.getName().equals(toDimFin.getName()))&&(!g.getModel().equals(toDimFin.getModel())))
				right=false;
		}
		
		assertTrue(right);
		
	}
	
	@Test
	public void testITM() {
        int result=0;
		
		GoodsVO g5=new GoodsVO("0002", "虚拟商品", "00020003", "不存在", "90", null, "77", "66", null, null, null);
		result=gbcontroller.increaseToMatch(g5, "");
		assertEquals(2004, result);
	}
	
	@Test
	public void testDTM() {
		 int result=0;
			
		 GoodsVO g6=new GoodsVO("0002", "虚拟商品", "00020003", "不存在", "90", null, "77", "66", null, null, null);
		 result=gbcontroller.decreaseToMatch(g6, "");
		 assertEquals(2004, result);
	}
	
	@Test
	public void testSetWL() {
		 int result=0;
			
		 GoodsVO g7=new GoodsVO("0002", "虚拟商品", "00020003", "不存在", null, null, "77", "66", null, null, "0");
		 result=gbcontroller.increaseToMatch(g7, "");
		 assertEquals(2004, result);
	}
	
	@Test
	public void testGetAlarm() {
		
		boolean right=true;
		ArrayList<GoodsAlarmVO> gal=gbcontroller.getGoodsAlarm();
		if(gal==null)
			right=false;
		assertTrue(right);
	}
	
}
