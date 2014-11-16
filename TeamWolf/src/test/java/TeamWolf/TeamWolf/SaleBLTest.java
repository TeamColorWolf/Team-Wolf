package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBL_driver;
import TeamWolf.TeamWolf.client.BL.saleBL.SaleBL_Driver;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleBLTest {

	ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
	static SaleBL_Driver saleDiv;
	CustomerVO cvo = new CustomerVO("0001", "进货商", "5", "习近平", "19999999999",
			"北京", "100000", "xjp@software.nju.edu.cn", "999999", "0", "0", "WKS");
	ImportListVO ivo = new ImportListVO("Import", cvo, "1", "WKS", goodsList, "nothing");
	ImportRejectListVO irvo = new ImportRejectListVO("ImportReject", cvo, "0", "WKS", goodsList, "nothing");
	SaleListVO svo = new SaleListVO("Sale", cvo, "XaioMing", "WKS", "0", goodsList, "0", "0", "nothing");
	SaleRejectListVO srvo = new SaleRejectListVO("SaleReject", cvo, "XaioMing", "WKS", "0", goodsList, "0", "0", "nothing");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String IP="127.0.0.1";
		saleDiv = new SaleBL_Driver(IP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testAddCustomer() {
		assertEquals(7, saleDiv.addCustomer(cvo));
	}

	@Test
	public void testDelCustomer() {
		assertEquals(7, saleDiv.delCustomer("0001", "习近平", cvo));
	}

	@Test
	public void testModCustomer() {
		assertEquals(7, saleDiv.modCustomer(cvo));
	}

	@Test
	public void testCreateImport() {
		assertEquals(7, saleDiv.createImport(ivo));
	}

	@Test
	public void testCreateImportReject() {
		assertEquals(7, saleDiv.createImportReject(irvo));
	}

	@Test
	public void testCreateSale() {
		assertEquals(7, saleDiv.createSale(svo));
	}

	@Test
	public void testCreateSaleReject() {
		assertEquals(7, saleDiv.createSaleReject(srvo));
	}


	@Test
	public void testSubmit() {
		assertEquals(7, saleDiv.submit(ivo));
		assertEquals(7, saleDiv.submit(irvo));
		assertEquals(7, saleDiv.submit(svo));
		assertEquals(7, saleDiv.submit(srvo));
	}

}
