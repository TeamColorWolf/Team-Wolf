package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionBLController;
import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForSaleService;
import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

@FixMethodOrder(MethodSorters.JVM)
public class PromotionTest {

	static String IP;
	static PromotionBLservice ps;
	static PromotionForSaleService psForSale;
	static PromotionVO[] pvo;
	static ArrayList<TypeVO> typelist;
	static ArrayList<String> goodsnumlist;
	static ArrayList<String> goodsAmolist;
	static TimeVO begin;
	static TimeVO end;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IP = "127.0.0.1";
		ps = new PromotionBLController(IP);
		
		begin = new TimeVO("2000", "01", "01");
		end = new TimeVO("2014", "12", "31");
		
		typelist = ps.typeList();
		goodsnumlist = new ArrayList<String>();
		goodsAmolist = new ArrayList<String>();
		for(int i = 0; i < typelist.size(); i++){
			ArrayList<GoodsVO> list = typelist.get(i).getAllLeave();
			for(int j = 0; j < list.size(); j++){
				goodsnumlist.add(list.get(j).getNumber());
				goodsAmolist.add("1");
			}
		}
		
		pvo = new PromotionVO[3];
		pvo[0] = new ForVIPPromotionVO(goodsnumlist, goodsAmolist, "100", "200", 3, begin, end);
		pvo[1] = new ForPricePromotionVO(goodsnumlist, goodsAmolist, "300", "1000", begin, end);
		pvo[2] = new SpecialGoodsPromotionVO(goodsnumlist, goodsAmolist, "2000", begin, end);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test_001_addPromotion() {
		for(int i = 0; i < pvo.length; i++){
			int success = ps.addPromotion(pvo[i]);
			assertEquals(success, 0);
			assertEquals(0, ps.getPromotion(pvo[i].number).error);
			assertEquals(pvo[i].number, ps.getPromotion(pvo[i].number).number);
		}
	}
	
	@Test
	public void test_002_delPromotion(){
		for(int i = 0; i < pvo.length; i++){
			int success = ps.delet(pvo[i].number);
			assertEquals(success, 0);
		}
	}
	
	@Test
	public void test_003_delNotExistPromotion(){
		int fail = ps.delet("forVIP_99999");
		assertEquals(fail, ErrorTW.notFound);
	}
	
	@Test
	public void test_004_timeError(){
		PromotionVO vo = new ForVIPPromotionVO(goodsnumlist, goodsAmolist, "100", "200", 3, end, begin);
		assertEquals(vo.error, ErrorTW.timeError);
	}
	
	@Test
	public void test_005_priceError(){
		PromotionVO vo = new ForVIPPromotionVO(goodsnumlist, goodsAmolist, "a", "200", 3, end, begin);
		assertEquals(vo.error, ErrorTW.shouldBeDouble);
	}
	
	@Test
	public void test_006_numberError(){
		goodsAmolist.remove(goodsAmolist.size()-1);
		goodsAmolist.add("a");
		PromotionVO vo = new ForVIPPromotionVO(goodsnumlist, goodsAmolist, "100", "200", 3, end, begin);
		assertEquals(vo.error, ErrorTW.shouldBeInteger);
		goodsAmolist.remove(goodsAmolist.size()-1);
		goodsAmolist.add("1");
	}
	
	@Test
	public void test_007_shouldBePositive(){
		PromotionVO vo = new ForVIPPromotionVO(goodsnumlist, goodsAmolist, "-100", "-200", 3, end, begin);
		assertEquals(vo.error, ErrorTW.shoulbBePositive);
	}

}
