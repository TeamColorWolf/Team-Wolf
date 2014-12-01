package TeamWolf.TeamWolf.client.BL.saleBL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class SaleBL_Driver{

	SaleBLController saleCtrl;
	String IP;
	
	public SaleBL_Driver(String IP) {
		this.IP = IP;
		saleCtrl = new SaleBLController(IP);
	}
	
	
	public static void main(String[] args) throws IOException {
//		String ip = "127.0.0.1";
//		SaleBL_Driver sbd = new SaleBL_Driver(ip);
//		sbd.driver();

		System.out.print("Please input server IP : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SaleBL_Driver sd = new SaleBL_Driver(br.readLine());

		// TODO:Test
		CustomerVO cvo = new CustomerVO("0001", "进货商", "5", "习近平", "19999999999",
				"北京", "100000", "xjp@software.nju.edu.cn", "999999", "0", "0", "WKS");
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		ImportListVO ivo = new ImportListVO("Import", cvo, "1", "WKS", goodsList, "nothing", "0");
		System.out.println(sd.createImport(ivo));

	}
	
	public int addCustomer(CustomerVO cvo) {
		return saleCtrl.addCustomer(cvo);
	}

	public int delCustomer(String number, String name, CustomerVO cvo) {
		int num = Integer.parseInt(number);
		return saleCtrl.delCustomer(name, number);
	}

	public int modCustomer(CustomerVO cvo) {
		return saleCtrl.modCustomer(cvo);
	}

	public int createImport(ImportListVO ivo) {
		return saleCtrl.createImport(ivo);
	}

	public int createImportReject(ImportRejectListVO irvo) {
		return saleCtrl.createImportReject(irvo);
	}

	public int createSale(SaleListVO svo) {
		return saleCtrl.createSale(svo);
	}

	public int createSaleReject(SaleRejectListVO srvo) {
		return saleCtrl.createSaleReject(srvo);
	}

	public int submit(ApplicationVO avo) {
		return saleCtrl.submit(avo);
	}
	
	public void driver() {
		SaleBL_Stub sbs = new SaleBL_Stub();
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		CustomerVO cvo = new CustomerVO("0001", "进货商", "5", "习近平", "19999999999",
				"北京", "100000", "xjp@software.nju.edu.cn", "999999", "0", "0", "WKS");
		ImportListVO ivo = new ImportListVO("Import", cvo, "1", "WKS", goodsList, "nothing", "0");
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

}
