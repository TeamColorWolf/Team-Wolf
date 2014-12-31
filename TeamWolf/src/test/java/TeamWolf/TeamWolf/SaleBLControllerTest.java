package TeamWolf.TeamWolf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TeamWolf.TeamWolf.client.BL.saleBL.SaleBLController;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleBLControllerTest {

	static SaleBLController saleCtrl; 
	static CustomerVO importMan;
	static CustomerVO saleMan;
	static ArrayList<GoodsVO> wrongNumGoodsList = new ArrayList<GoodsVO>();

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String ip = "127.0.0.1";
		saleCtrl = new SaleBLController(ip);
		importMan = new CustomerVO("0001", "进货商", "5", "许元俊", "15633333333", "1B248",
				"210046", "xyj13@nju.edu.cn", "3000", "0", "0", "GYQ");
		saleMan = new CustomerVO("0002", "销售商", "3", "魏可松", "13984362016", "1B248",
				"210046", "wks13@nju.edu.cn", "5000", "0", "0", "WHJ");
		GoodsVO goods_1 = new GoodsVO("", "", "00001", "TKSD", "", "-1", 
				"10", "10", "10", "10", null);
		wrongNumGoodsList.add(goods_1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Test over");
	}

	@Test
	/**
	 * 测试生成进货单
	 */
	public void testCreateImport() {
		int result = 0;
		ImportListVO list_1 = new ImportListVO("JHD-20141215-00001", importMan, "仓库1", "WKS",
				wrongNumGoodsList, "", "0.0");
		result = saleCtrl.createImport(list_1);
		assertEquals(2, result);
		ImportListVO list_2 = new ImportListVO("JHD-20141215-100000", importMan, "仓库1", "WKS",
				wrongNumGoodsList, "", "0.0");
		result = saleCtrl.createImport(list_2);
		assertEquals(7008, result);
	}

	@Test
	/**
	 * 测试生成进货退货单
	 */
	public void testCreateImportReject() {
		int result = 0;
		ImportRejectListVO list_1 = new ImportRejectListVO("JHTHD-20141215-100000", importMan, 
				"仓库1", "WKS", wrongNumGoodsList, "");
		result = saleCtrl.createImportReject(list_1);
		assertEquals(7008, result);
	}

	@Test
	/**
	 * 测试生成销售单
	 */
	public void testCreateSale() {
		int result = 0;
		SaleListVO list_1 = new SaleListVO("XSD-20141215-00001", saleMan, "WKS", "WKS", 
			 "仓库1", wrongNumGoodsList, "0", "0", "0", "0", "0");
		result = saleCtrl.createSale(list_1);
		assertEquals(2, result);
		SaleListVO list_2 = new SaleListVO("XSD-20141215-100000", saleMan, "WKS", "WKS", 
				 "仓库1", wrongNumGoodsList, "0", "0", "0", "0", "0");
		result = saleCtrl.createSale(list_2);
		assertEquals(7008, result);
	}

	@Test
	/**
	 * 测试生成销售退货单
	 */
	public void testCreateSaleReject() {
		int result = 0;
		SaleRejectListVO list_1 = new SaleRejectListVO("XSD-20141215-100000", saleMan, "WKS", "WKS", 
				 "仓库1", wrongNumGoodsList, "0", "0", "0", "0", "0");
		result = saleCtrl.createSaleReject(list_1);
		assertEquals(7008, result);
	}

}
