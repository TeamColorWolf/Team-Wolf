package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
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
}
