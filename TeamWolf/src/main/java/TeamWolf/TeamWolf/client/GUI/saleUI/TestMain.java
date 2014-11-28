package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserVO user = new UserVO("WKS", "131250196", "0001", UserType.销售人员);
		String IP = "127.0.0.1";
		FunctionChoose fc = new FunctionChoose(user, IP);
	}

	public static ArrayList<CustomerVO> getCustVOListTEST(){
		ArrayList<CustomerVO> custList = new ArrayList<CustomerVO>();
		CustomerVO cvo1 = new CustomerVO("0001", "进货商", "1", "WHJ", "", "", "", "", "", "", "", "");
		CustomerVO cvo2 = new CustomerVO("0002", "销售商", "1", "习近平", "", "", "", "", "", "", "", "");
		CustomerVO cvo3 = new CustomerVO("0003", "进货商", "1", "WKS", "", "", "", "", "", "", "", "");
		CustomerVO cvo4 = new CustomerVO("0004", "进货商", "1", "XYJ", "", "", "", "", "", "", "", "");
		custList.add(cvo1);
		custList.add(cvo2);
		custList.add(cvo3);
		custList.add(cvo4);
		return custList;
	}
	
	public static ArrayList<ImportListVO> getImportListTEST(){
		ArrayList<ImportListVO> importList = new ArrayList<ImportListVO>();
		CustomerVO cvo1 = new CustomerVO("0001", "进货商", "1", "WHJ", "", "", "", "", "", "", "", "");
		ImportListVO imp1 = new ImportListVO("0001", cvo1, "", "", getGoodsListTEST(), "呵呵呵");
		ImportListVO imp2 = new ImportListVO("0002", cvo1, "", "", getGoodsListTEST(), "草草草");
		ImportListVO imp3 = new ImportListVO("0003", cvo1, "", "", getGoodsListTEST(), "呃呃呃");
		importList.add(imp1);
		importList.add(imp2);
		importList.add(imp3);
		return importList;
	}
	
	public static ArrayList<GoodsVO> getGoodsListTEST(){
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		GoodsVO gvo1 = new GoodsVO("", "", "0001", "充气娃娃", "", "10", "10", "10", "10", "10", "10");
		GoodsVO gvo2 = new GoodsVO("", "", "0002", "光剑", "", "10", "10", "10", "10", "10", "10");
		GoodsVO gvo3 = new GoodsVO("", "", "0003", "吞卡手电", "", "10", "10", "10", "10", "10", "10");
		goodsList.add(gvo1);
		goodsList.add(gvo2);
		goodsList.add(gvo3);
		return goodsList;
	}
}
