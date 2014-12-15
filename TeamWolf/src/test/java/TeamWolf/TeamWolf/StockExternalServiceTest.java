package TeamWolf.TeamWolf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockExternalServiceTest {

	static ExternalServiceController escontroller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		String IP="127.0.0.1";
		escontroller=new ExternalServiceController(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFind() {
		
		GoodsVO fin=escontroller.finGoods("00030001");
		assertEquals("00030001", fin.getNumber());
		fin=escontroller.finGoods("00000000");
		assertEquals(null, fin);
		
	}
    
	@Test
	public void testGetLeaveType() {
		
		ArrayList<TypeVO> tl=escontroller.getLeaveType();
		for(TypeVO t: tl){
			assertEquals(2, t.getC());
		}
	}

}
