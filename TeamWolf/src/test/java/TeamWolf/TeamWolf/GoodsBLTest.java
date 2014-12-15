package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
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

	 public static final int cannotAddGoods_1=2001;  //分类下有子分类不可添加商品
	    public static final int GoodsIsExisted=2002;  //商品已存在
	    public static final int notMatchToParent=2003; //商品与父类不匹配
	    public static final int GoodsIsnotExisted=2004; //商品不存在
	    public static final int notEnough=2006; //库存不足
	    public static final int specialGoodsGone=2007; //特价包已不存在
	    public static final int illegalTime=2008; //时间不合法
	    
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
		fail("Not yet implemented");
	}
	
	@Test
	public void testDimFin() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testITM() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDTM() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetWL() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAlarm() {
		fail("Not yet implemented");
	}
	
}
