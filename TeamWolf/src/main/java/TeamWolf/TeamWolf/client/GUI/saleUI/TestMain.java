package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserVO user = new UserVO("WKS", "131250196", "0001", UserType.销售人员);
		String IP = "127.0.0.1";
//		FunctionChoose fc = new FunctionChoose(user, IP);
	}
	
	public static ArrayList<CustomerVO> getCustVOListTEST(){
		ArrayList<CustomerVO> custList = new ArrayList<CustomerVO>();
		CustomerVO cvo1 = new CustomerVO("0001", "进货商", "1", "WHJ", "13311111111", "1B248", "210046", "whj@qq.com", "5000", "0", "0", "业务员1");
		CustomerVO cvo2 = new CustomerVO("0002", "销售商", "1", "习近平", "13911111111", "中南海", "100000", "xjp@hehe.com", "999999", "0", "0", "业务员2");
		CustomerVO cvo3 = new CustomerVO("0003", "进货商", "1", "WKS", "15611111111", "1B248", "210046", "wks@nju.com", "2000", "0", "0", "业务员3");
		CustomerVO cvo4 = new CustomerVO("0004", "进货商", "1", "XYJ", "15811111111", "1B248", "210046", "xyj@163.com", "3000", "0", "0", "业务员4");
		CustomerVO cvo5 = new CustomerVO("0005", "销售商", "1", "GYQ", "15911111111", "1B235", "210046", "gyq@hehe.com", "4000", "0", "0", "业务员5");
		custList.add(cvo1);
		custList.add(cvo2);
		custList.add(cvo3);
		custList.add(cvo4);
		custList.add(cvo5);
		return custList;
	}
	
	public static ArrayList<CustomerPO> getCustPOListTest(ArrayList<CustomerVO> cvoList){
		ArrayList<CustomerPO> custList = new ArrayList<CustomerPO>();
		for (int i = 0; i < cvoList.size(); i++) {
			CustomerPO cpo = new CustomerPO(cvoList.get(i));
			custList.add(cpo);
		}
		return custList;
	}
	
	public static ArrayList<ImportListVO> getImportListTEST(){
		ArrayList<ImportListVO> importList = new ArrayList<ImportListVO>();
		CustomerVO cvo1 = new CustomerVO("0001", "进货商", "1", "WHJ", "", "", "", "", "", "", "", "");
		ImportListVO imp1 = new ImportListVO("0001", cvo1, "", "", getGoodsListTEST1(), "呵呵呵", "0");
		ImportListVO imp2 = new ImportListVO("0002", cvo1, "", "", getGoodsListTEST2(), "草草草", "0");
		ImportListVO imp3 = new ImportListVO("0003", cvo1, "", "", getGoodsListTEST3(), "呃呃呃", "0");
		importList.add(imp1);
		importList.add(imp2);
		importList.add(imp3);
		return importList;
	}
	
	public static ArrayList<SaleListVO> getSaleListTEST(){
		ArrayList<SaleListVO> saleList = new ArrayList<SaleListVO>();
		CustomerVO cvo1 = new CustomerVO("0001", "销售商", "1", "许老j", "", "", "", "", "", "", "", "");
		SaleListVO sal1 = new SaleListVO("0001", cvo1, "", "", "", getGoodsListTEST3(), "1000", "0", "sal1", "0", "0");
		SaleListVO sal2 = new SaleListVO("0001", cvo1, "", "", "", getGoodsListTEST4(), "3000", "0", "sal2", "0", "0");
		saleList.add(sal1);
		saleList.add(sal2);
		return saleList;
	}
	
	public static ArrayList<GoodsVO> getGoodsListTEST1(){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		GoodsVO gvo1 = new GoodsVO("", "", "0001", "充气娃娃", "", "1", "10", "10", "10", "10", "10");
		GoodsVO gvo2 = new GoodsVO("", "", "0002", "光剑", "", "2", "10", "10", "10", "10", "10");
		GoodsVO gvo3 = new GoodsVO("", "", "0003", "吞卡手电", "", "3", "10", "10", "10", "10", "10");
		goodsList.add(gvo1);
		goodsList.add(gvo2);
		goodsList.add(gvo3);
		return goodsList;
	}
	
	public static ArrayList<GoodsVO> getGoodsListTEST2(){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		GoodsVO gvo1 = new GoodsVO("", "", "0001", "比基尼全套", "", "11", "10", "10", "10", "10", "10");
		GoodsVO gvo2 = new GoodsVO("", "", "0002", "蕾丝内裤", "", "22", "10", "10", "10", "10", "10");
		GoodsVO gvo3 = new GoodsVO("", "", "0003", "丝袜", "", "33", "10", "10", "10", "10", "10");
		goodsList.add(gvo1);
		goodsList.add(gvo2);
		goodsList.add(gvo3);
		return goodsList;
	}
	
	public static ArrayList<GoodsVO> getGoodsListTEST3(){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		GoodsVO gvo1 = new GoodsVO("", "", "0001", "黄瓜", "", "111", "10", "10", "10", "10", "10");
		GoodsVO gvo2 = new GoodsVO("", "", "0002", "茄子", "", "222", "10", "20", "10", "10", "10");
		GoodsVO gvo3 = new GoodsVO("", "", "0003", "胡萝卜", "", "333", "10", "30", "10", "10", "10");
		goodsList.add(gvo1);
		goodsList.add(gvo2);
		goodsList.add(gvo3);
		return goodsList;
	}
	
	public static ArrayList<GoodsVO> getGoodsListTEST4(){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		GoodsVO gvo1 = new GoodsVO("", "", "0001", "PSP", "", "1111", "10", "1000", "10", "10", "10");
		GoodsVO gvo2 = new GoodsVO("", "", "0002", "PS4", "", "2222", "10", "2000", "10", "10", "10");
		GoodsVO gvo3 = new GoodsVO("", "", "0003", "XBOX360", "", "3333", "10", "3000", "10", "10", "10");
		goodsList.add(gvo1);
		goodsList.add(gvo2);
		goodsList.add(gvo3);
		return goodsList;
	}
	
	public static ArrayList<GoodsVO> getGoodsListTESTmax(){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		
		
		
		return goodsList;
	}
}
