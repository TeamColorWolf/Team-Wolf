package TeamWolf.TeamWolf.client.BL.saleBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleBL_Driver {

	SaleBL_Stub sbs = new SaleBL_Stub();
	ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
	
	public SaleBL_Driver() {
		CustomerVO cvo = new CustomerVO("0001", "进货商", "5", "习近平", "19999999999",
				"北京", "100000", "xjp@software.nju.edu.cn", "999999", "0", "0", "WKS");
		ImportListVO ivo = new ImportListVO("Import", cvo, "1", "WKS", goodsList, "nothing");
		ImportRejectListVO irvo = new ImportRejectListVO("ImportReject", cvo, "0", "WKS", goodsList, "nothing");
		SaleListVO svo = new SaleListVO("Sale", cvo, "XaioMing", "WKS", "0", goodsList, "0", "0", "nothing");
		SaleRejectListVO srvo = new SaleRejectListVO("SaleReject", cvo, "XaioMing", "WKS", "0", goodsList, "0", "0", "nothing");
		//客户操作
		sbs.addCustomer(cvo);
		sbs.modCustomer(cvo);
		sbs.findCustomer(cvo.getName(), cvo.getNum());
		sbs.delCustomer(cvo);
		//创建进货单
		sbs.createImport(ivo);
		sbs.submit(ivo);
		//创建进货退货单
		sbs.createImportReject(irvo);
		sbs.submit(irvo);
		//创建销售单
		sbs.createSale(svo);
		sbs.submit(svo);
		//创建销售退货单
		sbs.createSaleReject(srvo);
		sbs.submit(srvo);
	}
	
	public static void main(String[] args) {
		SaleBL_Driver sbd = new SaleBL_Driver();
	}

}
